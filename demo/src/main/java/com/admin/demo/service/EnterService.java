package com.admin.demo.service;

import com.admin.demo.data.EnterDO;
import com.admin.demo.dto.EnterDto;

import java.util.List;

public interface EnterService {
    EnterDto insertOne(EnterDO enterDO);
    EnterDto getByActivity(Integer activitesId);
    EnterDto getByUser(Integer userId);
    EnterDto getUserTotal(Integer userId);
    EnterDto del(Integer id);
    EnterDto updateAll(List<EnterDO>list);

}
