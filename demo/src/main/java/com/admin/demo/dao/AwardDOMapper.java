package com.admin.demo.dao;

import com.admin.demo.data.AwardDO;

public interface AwardDOMapper {
    int insert(AwardDO record);

    int insertSelective(AwardDO record);
}