package com.admin.demo.service;

import com.admin.demo.data.AwardDO;
import com.admin.demo.dto.AwardDto;

import java.util.List;

public interface AwardService {
     //根据年份获取
     AwardDto getByYear(Integer year);
     //生成当年星级志愿者
//      AwardDto insertAll(List<AwardDO> awardDO);
 }
