package com.admin.demo.service;

import com.admin.demo.dto.VolunteerScoreStatisticsDTO;
import com.admin.demo.result.ResultDO;

import java.util.List;

public interface VolunteerScoreStatisticsService {

    ResultDO<List<VolunteerScoreStatisticsDTO>> queryVolunteerScopreStatistics(String inputYear);

}
