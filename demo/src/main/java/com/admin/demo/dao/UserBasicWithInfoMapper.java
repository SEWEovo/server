package com.admin.demo.dao;

import com.admin.demo.data.UserBasicWithInfoDO;

import java.util.List;


public interface UserBasicWithInfoMapper {

    List<UserBasicWithInfoDO> selectPermissionStudent();
    List<UserBasicWithInfoDO> selectAll();

}
