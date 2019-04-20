package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {
    // 通过用户id获取用户对象的方法
    UserModel getUserById(Integer id);


    // 用户注册
    void register(UserModel userModel) throws BusinessException;
}
