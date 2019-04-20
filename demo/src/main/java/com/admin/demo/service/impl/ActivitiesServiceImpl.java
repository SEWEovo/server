package com.admin.demo.service.impl;

import com.admin.demo.dao.ActivitiesDOMapper;
import com.admin.demo.data.ActivitiesDO;
import com.admin.demo.dto.ActivitiesDto;
import com.admin.demo.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
        @Autowired(required = true)
        private ActivitiesDOMapper activitiesDOMapper;
        @Override
        public ActivitiesDto selectAll(ActivitiesDO activitiesDO){
             List<ActivitiesDO> list = new ArrayList<ActivitiesDO>();
             list =activitiesDOMapper.selectAll(activitiesDO);
             ActivitiesDto ActivitiesDto=new ActivitiesDto();
             if(list.size()!=0){
                 ActivitiesDto.setCode("ACK");
                 ActivitiesDto.setMsg("查询成功");
                 ActivitiesDto.setData(list);
             }else {
                 ActivitiesDto.setCode("ACK");
                 ActivitiesDto.setMsg("暂无");
             }
             return  ActivitiesDto;
        }
    @Override
    public ActivitiesDto selectByPublish(ActivitiesDO activitiesDO){
        List<ActivitiesDO> list = new ArrayList<ActivitiesDO>();
        list =activitiesDOMapper.selectByPublish(activitiesDO);
        ActivitiesDto ActivitiesDto=new ActivitiesDto();
        if(list.size()!=0){
            ActivitiesDto.setCode("ACK");
            ActivitiesDto.setMsg("查询成功");
            ActivitiesDto.setData(list);
        }else {
            ActivitiesDto.setCode("ACK");
            ActivitiesDto.setMsg("暂时没有发布志愿者活动");
        }
        return  ActivitiesDto;
    }
    @Override
    public ActivitiesDto getLast(Integer id){
            Object result=activitiesDOMapper.getLast(id);
//        List<ActivitiesDO> list = new ArrayList<ActivitiesDO>();
//        list =activitiesDOMapper.getLast();
        ActivitiesDto ActivitiesDto=new ActivitiesDto();
        if(result !=null){
            ActivitiesDto.setCode("ACK");
            ActivitiesDto.setMsg("查询成功");
            ActivitiesDto.setData(result);
        }else {
            ActivitiesDto.setCode("ACK");
            ActivitiesDto.setMsg("暂无最新数据");
        }
        return  ActivitiesDto;
    }
    @Override
    public ActivitiesDto publish(ActivitiesDO ac){
        int result =activitiesDOMapper.insert(ac);
        int num=ac.getActivitesId();
        ActivitiesDto ActivitiesDto=new ActivitiesDto();
        if(result!=0){
            ActivitiesDto.setCode("ACK");
            ActivitiesDto.setData(num);
            ActivitiesDto.setMsg("发布成功");
        }else {
            ActivitiesDto.setCode("NACK");
            ActivitiesDto.setMsg("发布失败");
        }
        return  ActivitiesDto;
    }
      @Override
     public ActivitiesDto edit(ActivitiesDO activity){
         int result =activitiesDOMapper.updateByPrimaryKeySelective(activity);
         ActivitiesDto ActivitiesDto=new ActivitiesDto();
         if(result!=0){
             ActivitiesDto.setCode("ACK");
             ActivitiesDto.setMsg("编辑成功");
         }else {
             ActivitiesDto.setCode("NACK");
             ActivitiesDto.setMsg("编辑失败");
         }
         return  ActivitiesDto;
         }
    @Override
    public ActivitiesDto updateStatus(Integer id){
        int result =activitiesDOMapper.updateStatus(id);
        ActivitiesDto ActivitiesDto=new ActivitiesDto();
        if(result!=0){
            ActivitiesDto.setCode("ACK");
            ActivitiesDto.setMsg("状态更新成功");
        }else {
            ActivitiesDto.setCode("NACK");
            ActivitiesDto.setMsg("状态更新失败");
        }
        return  ActivitiesDto;
    }

}
