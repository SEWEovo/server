package com.admin.demo.dao;

import com.admin.demo.data.EnterDO;

public interface EnterDOMapper {
    int deleteByPrimaryKey(Integer enterId);

    int insert(EnterDO record);

    int insertSelective(EnterDO record);

    EnterDO selectByPrimaryKey(Integer enterId);

    int updateByPrimaryKeySelective(EnterDO record);

    int updateByPrimaryKey(EnterDO record);
}