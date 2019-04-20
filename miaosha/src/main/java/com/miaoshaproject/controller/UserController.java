package com.miaoshaproject.controller;

import com.alibaba.druid.util.StringUtils;
import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 * @author : Fpromiss
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*") // 解决跨域访问问题
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest; // 虽然是单例，但是本质是一个Proxy


    // 用户注册接口
    @RequestMapping(value = "/register",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "telphone")String telphone,
                                     @RequestParam(name = "otpCode")String otpCode,
                                     @RequestParam(name = "name")String name,
                                     @RequestParam(name = "gender")String gender,
                                     @RequestParam(name = "age")Integer age,
                                     @RequestParam(name = "password")String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        // 验证手机号和对应的otpCode相符合
        String inSessionotpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone); // 获取otpCode
        if(!StringUtils.equals(otpCode, inSessionotpCode)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符合");
        }
        // 用户注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(gender));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterMode("byphone");
        userModel.setEncrptPassword(this.EncodeByMD5(password)); // 密码加密存储(java 常规md5只有16位，容易null)

        userService.register(userModel);
        return CommonReturnType.create(null);
    }


    public String EncodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定一个计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 加密字符串
        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

    // 用户获取opt短信接口
    @RequestMapping(value = "/getotp",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telphone")String telphone){
        // 需要按照一定的规则生成OPT验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt = randomInt + 10000;
        String optCode = String.valueOf(randomInt);

        // 将OPT验证码同对应用户的手机号关联,使用http session 的方式绑定手机号与optCode
        httpServletRequest.getSession().setAttribute(telphone, optCode);

        // 将OPT验证码通过短信通道发送给用户(省略)
        System.out.println("telphone = " + telphone + " & optCode = " + optCode);
        return CommonReturnType.create(null);
    }


    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        // 调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        // 若获取的对应用户信息不存在
        if(userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        // 将核心领域模型用户对象转换为可供UI使用的viewobject
        UserVO userVO = convertFromModel(userModel);
        // 返回通用对象
        return CommonReturnType.create(userVO);
    }

    /**
     * 将 userModel 转换为 userVO
     *
     * @param userModel
     * @return
     */
    private UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }
}
