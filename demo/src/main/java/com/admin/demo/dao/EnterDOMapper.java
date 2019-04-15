package com.admin.demo.dao;

import com.admin.demo.data.EnterDO;
import com.admin.demo.data.EnterTotal;
import com.admin.demo.query.VolunteerScoreQuery;

import java.util.List;

public interface EnterDOMapper {
    int deleteByPrimaryKey(Integer enterId);

    int insert(EnterDO record);

    int insertSelective(EnterDO record);

    EnterDO selectByPrimaryKey(Integer enterId);

    EnterDO selectEnter(EnterDO enterDO);

    int updateByPrimaryKeySelective(EnterDO record);

    int updateByPrimaryKey(EnterDO record);

    List<EnterDO> selectVolunteerScore(VolunteerScoreQuery query);

    List<EnterTotal> getUserTotal(Integer userId);

}