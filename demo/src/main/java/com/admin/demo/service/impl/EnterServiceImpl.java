package com.admin.demo.service.impl;

import com.admin.demo.dao.EnterDOMapper;
import com.admin.demo.dao.EnterWithauDOMapper;
import com.admin.demo.data.EnterDO;
import com.admin.demo.data.EnterWithauDO;
import com.admin.demo.dto.EnterDto;
import com.admin.demo.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterServiceImpl implements EnterService {
    @Autowired(required = true)
    private EnterWithauDOMapper enterWithauDOMapper;
    @Autowired(required = true)
    private  EnterDOMapper enterDOMapper;
    //报名
    @Override
    public EnterDto insertOne(EnterDO enterDO){

        int result =enterDOMapper.insert(enterDO);
        //需要在插入之前查询num数是否已满
        EnterDto enterDto=new EnterDto();
        if(result!=0){
            enterDto.setCode("ACK");
            enterDto.setMsg("报名成功");
        }else {
            enterDto.setCode("NACK");
            enterDto.setMsg("报名失败");
        }
        return  enterDto;
    }
    //获取某活动的用户报名情况
    @Override
    public EnterDto getByActivity(Integer activitesId){
        List<EnterWithauDO> list = new ArrayList<EnterWithauDO>();
        list =enterWithauDOMapper.selectByActivity(activitesId);
        EnterDto enterDto=new EnterDto();
        if(list.size()!=0){
            enterDto.setCode("ACK");
            enterDto.setMsg("查询成功");
            enterDto.setData(list);
        }else {
            enterDto.setCode("NACK");
            enterDto.setMsg("查询失败");
        }
        return  enterDto;
    }
    //获取某个用户参加的活动
    @Override
    public EnterDto getByUser(Integer userId){
        List<EnterWithauDO> list = new ArrayList<EnterWithauDO>();
        list =enterWithauDOMapper.selectByUser(userId);
        EnterDto enterDto=new EnterDto();
        if(list.size()!=0){
            enterDto.setCode("ACK");
            enterDto.setMsg("查询成功");
            enterDto.setData(list);
        }else {
            enterDto.setCode("NACK");
            enterDto.setMsg("查询失败");
        }
        return  enterDto;
    }
}
