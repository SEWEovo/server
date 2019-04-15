package com.admin.demo.test;

import com.admin.demo.DemoApplication;
import com.admin.demo.result.ResultDO;
import com.admin.demo.service.VolunteerScoreStatisticsService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2019-04-09 23:47:50
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class VolunteerScoreStatisticsServiceTest {

    @Resource
    private VolunteerScoreStatisticsService volunteerScoreStatisticsService;

    @Test
    public void testQueryScore() {
        String inputYear = "2018";
        ResultDO resultDO = volunteerScoreStatisticsService.queryVolunteerScopreStatistics(inputYear);
        System.out.println(JSON.toJSONString(resultDO, true));
    }

}
