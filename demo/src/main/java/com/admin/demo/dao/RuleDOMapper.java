package com.admin.demo.dao;

import com.admin.demo.data.RuleDO;

public interface RuleDOMapper {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(RuleDO record);

    int insertSelective(RuleDO record);

    RuleDO selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(RuleDO record);

    int updateByPrimaryKey(RuleDO record);

    RuleDO selectFirst();

}