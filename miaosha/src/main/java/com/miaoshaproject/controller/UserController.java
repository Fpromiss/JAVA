package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


/**
 * @author : Fpromiss
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest; // 虽然是单例，但是本质是一个Proxy

    // 用户获取opt短信接口
    @RequestMapping("/getOpt")
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
