package com.admin.demo.dao;

import com.admin.demo.data.ActivitiesDO;

import java.util.List;

public interface ActivitiesDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivitiesDO record);

    int insertSelective(ActivitiesDO record);

    ActivitiesDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivitiesDO record);

    int updateByPrimaryKey(ActivitiesDO record);

    List<ActivitiesDO> selectAll();
}