package com.admin.demo.service;

import com.admin.demo.data.UserBasicDO;
import com.admin.demo.dto.UserDto;

public interface UserService {
    UserDto login(String account,String password);
    //获取权限名单
    UserDto  findAll();
    //添加权限
    UserDto  add(UserBasicDO userBasicDO);
    //删除权限
    UserDto  del(UserBasicDO userBasicDO);
    //获得单个用户个人信息
    //UserInfoDto findOneInfo(int id);
    //获得所有用户个人信息
    //UserInfoDto findAllInfo();

}
