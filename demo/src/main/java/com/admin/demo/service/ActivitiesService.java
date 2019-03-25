package com.admin.demo.service;

import com.admin.demo.dto.ActivitiesDto;

public interface ActivitiesService {
    int publish();
    int edit();
    ActivitiesDto selectAll();
    ActivitiesDto selectById();
}
