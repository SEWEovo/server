package com.admin.demo.dao;

import com.admin.demo.data.AwardDO;

import java.util.List;

public interface AwardDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardDO record);

    int insertSelective(AwardDO record);

    List<AwardDO> selectByPrimaryKey(Integer year);

    List<AwardDO> selectByUser(Integer id);

    int updateByPrimaryKeySelective(AwardDO record);

    int updateByPrimaryKey(AwardDO record);

    int insertAll(List<AwardDO> resultList);

}