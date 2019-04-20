package com.admin.demo.dao;

import com.admin.demo.data.ActivitiesDO;

import java.util.List;

public interface ActivitiesDOMapper {
    int deleteByPrimaryKey(Integer activitesId);

    int insert(ActivitiesDO record);

    int insertSelective(ActivitiesDO record);

    ActivitiesDO selectByPrimaryKey(Integer activitesId);

    ActivitiesDO getLast(Integer userId);

    int updateByPrimaryKeySelective(ActivitiesDO record);

    int updateByPrimaryKey(ActivitiesDO record);
    //根据条件获取志愿者活动
    List<ActivitiesDO> selectAll(ActivitiesDO record);

    int updateStatus(Integer id);

    ActivitiesDO selectNum(Integer activitesId);
    //获取当前用户发布的志愿活动
    List<ActivitiesDO> selectByPublish(ActivitiesDO record);


}