package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {
    // 通过用户id获取用户对象的方法
    UserModel getUserById(Integer id);


    // 用户注册
    void register(UserModel userModel) throws BusinessException;


    /**
     * 用户合法性登录判断
     *
     * @param telphone 用户手机
     * @param encrptPassword 用户加密之后的密码
     * @throws BusinessException
     */
    UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException;
}
