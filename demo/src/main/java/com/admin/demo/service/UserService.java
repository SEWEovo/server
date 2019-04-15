package com.admin.demo.service;

import com.admin.demo.data.UserBasicDO;
import com.admin.demo.data.UserInfoDO;
import com.admin.demo.dto.UserDto;

public interface UserService {
    UserDto login(String account, String password);

    UserDto loginAdmin(String account,String password,Integer type);
    //添加权限
    UserDto  add(UserBasicDO userBasicDO);
    //删除权限
    UserDto  del(UserBasicDO userBasicDO);
    //获取有权限的学生名单
    UserDto selectPermissionStudent();
    //获取没有权限的学生名单
    UserDto selectAll();
    //获取单个学生个人信息
    UserDto selectInfo(Integer userId);
    //更新学生联系方式
    UserDto updateInfo(UserInfoDO userInfoDO);
}
