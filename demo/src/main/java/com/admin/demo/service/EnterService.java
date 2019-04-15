package com.admin.demo.service;

import com.admin.demo.data.EnterDO;
import com.admin.demo.dto.EnterDto;

public interface EnterService {
    EnterDto insertOne(EnterDO enterDO);
    EnterDto getByActivity(Integer activitesId);
    EnterDto getByUser(Integer userId);
    EnterDto getUserTotal(Integer userId);
    EnterDto del(Integer id);

}
