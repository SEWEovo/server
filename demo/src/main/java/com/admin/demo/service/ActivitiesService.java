package com.admin.demo.service;

import com.admin.demo.data.ActivitiesDO;
import com.admin.demo.dto.ActivitiesDto;

public interface ActivitiesService {
    ActivitiesDto publish(ActivitiesDO activity);
    ActivitiesDto edit(ActivitiesDO activitiesDO);
    ActivitiesDto selectAll(ActivitiesDO activitiesDO);
//    ActivitiesDto selectById();
}
