package com.admin.demo.dao;

import com.admin.demo.data.UserBasicDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBasicDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBasicDO record);

    int insertSelective(UserBasicDO record);

    UserBasicDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBasicDO record);

    int updateByPrimaryKey(UserBasicDO record);

    UserBasicDO login(@Param("account") String account,@Param("password") String password);

    List<UserBasicDO> findAll();
}