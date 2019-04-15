package com.admin.demo.service.impl;

import com.admin.demo.dao.EnterDOMapper;
import com.admin.demo.dao.RuleDOMapper;
import com.admin.demo.dao.UserInfoDOMapper;
import com.admin.demo.data.EnterDO;
import com.admin.demo.data.RuleDO;
import com.admin.demo.data.UserInfoDO;
import com.admin.demo.dto.VolunteerScoreStatisticsDTO;
import com.admin.demo.query.VolunteerScoreQuery;
import com.admin.demo.result.ResultDO;
import com.admin.demo.service.VolunteerScoreStatisticsService;
import com.admin.demo.utils.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
@Service
@Slf4j
public class VolunteerScoreStatisticsServiceImpl implements VolunteerScoreStatisticsService {

    @Resource
    private UserInfoDOMapper userInfoDOMapper;

    @Resource
    private EnterDOMapper enterDOMapper;

    @Resource
    private RuleDOMapper ruleDOMapper;

    @Override
    public ResultDO<List<VolunteerScoreStatisticsDTO>> queryVolunteerScopreStatistics(String inputYear) {
        if (StringUtils.isBlank(inputYear)) {
            return ResultDO.buildError("输入的年份不能为空");
        }
        List<UserInfoDO> userInfoDOS = userInfoDOMapper.selectAll();
        // 学生信息为空，则直接返回
        if (CollectionUtils.isEmpty(userInfoDOS)) {
            return ResultDO.buildSuccess(new ArrayList<>());
        }
        RuleDO ruleDO = ruleDOMapper.selectFirst();
        if (null == ruleDO || null == ruleDO.getCount() || null == ruleDO.getTotaltime()) {
            return ResultDO.buildError("未设置评分规则");
        }
        // 次数标准&时长标准
        Integer count = ruleDO.getCount();
        BigDecimal countStandard = (new BigDecimal(count)).movePointLeft(2).setScale(2, BigDecimal.ROUND_HALF_UP);
        Integer totalTime = ruleDO.getTotaltime();
        BigDecimal totalTimeStandard = (new BigDecimal(totalTime)).movePointLeft(2).setScale(2, BigDecimal.ROUND_HALF_UP);
        // 以学号为维度聚合学生
        List<Integer> userIdList = userInfoDOS.stream().map(UserInfoDO::getUserId).collect(Collectors.toList());
        VolunteerScoreQuery query = new VolunteerScoreQuery();
        query.setYear(inputYear);
        query.setVolunteerIds(userIdList);
        List<EnterDO> enterDOS = enterDOMapper.selectVolunteerScore(query);
        if (CollectionUtils.isEmpty(enterDOS)) {
            return ResultDO.buildSuccess(new ArrayList<>());
        }
        // 按照学号进行聚合
        Map<Integer, List<EnterDO>> enterListMap = new HashMap<>();
        enterDOS.forEach(x -> {
            List<EnterDO> enterDOList = enterListMap.get(x.getUserId());
            if (CollectionUtils.isEmpty(enterDOList)) {
                enterDOList = new LinkedList<>();
                enterDOList.add(x);
            } else {
                enterDOList.add(x);
            }
            enterListMap.put(x.getUserId(), enterDOList);
        });
        // 进行计算，并将值返回
        List<VolunteerScoreStatisticsDTO> statisticsDTOS = new LinkedList<>();
        userInfoDOS.forEach(x -> {
            VolunteerScoreStatisticsDTO statisticsDTO = new VolunteerScoreStatisticsDTO();
            statisticsDTO.setUserId(x.getUserId());
            statisticsDTO.setName(x.getName());
            statisticsDTO.setCollege(x.getCollege());
            statisticsDTO.setProfession(x.getProfession());
            statisticsDTO.setClassNum(x.getClassNum());
            List<EnterDO> enterDOList = enterListMap.get(x.getUserId());
            if (CollectionUtils.isEmpty(enterDOList)) {
                statisticsDTO.setTimes(0);
                statisticsDTO.setLongTime(0);
                statisticsDTO.setScore(BigDecimal.ZERO);
            } else {
                // 获取总次数
                int countTime = enterDOList.size();
                // 获取总时长
                Integer totalLongTime = 0;
                for (EnterDO enterDO : enterDOList) {
                    totalLongTime += enterDO.getLongtime();
                }
                statisticsDTO.setTimes(countTime);
                statisticsDTO.setLongTime(totalLongTime);
                statisticsDTO.setCount(countTime);
                BigDecimal score = (new BigDecimal(countTime)).multiply(countStandard).add((new BigDecimal(totalLongTime).multiply(totalTimeStandard))).setScale(2, BigDecimal.ROUND_HALF_UP);
                statisticsDTO.setScore(score);
            }
            statisticsDTOS.add(statisticsDTO);
        });
        statisticsDTOS.removeIf(x -> x.getScore() != null && BigDecimal.ZERO.equals(x.getScore()));
        statisticsDTOS.sort((x1, x2) -> x2.getScore().compareTo(x1.getScore()));
        return ResultDO.buildSuccess(statisticsDTOS, statisticsDTOS.size());
    }

}
