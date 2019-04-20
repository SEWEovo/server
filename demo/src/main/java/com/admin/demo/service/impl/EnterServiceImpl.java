package com.admin.demo.service.impl;

import com.admin.demo.dao.ActivitiesDOMapper;
import com.admin.demo.dao.EnterDOMapper;
import com.admin.demo.dao.EnterWithauDOMapper;
import com.admin.demo.data.ActivitiesDO;
import com.admin.demo.data.EnterDO;
import com.admin.demo.data.EnterTotal;
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
    @Autowired(required = true)
    private  ActivitiesDOMapper activitiesDOMapper;
    //报名
    @Override
    public EnterDto insertOne(EnterDO enterDO){
        EnterDto enterDto=new EnterDto();
       EnterDO e=enterDOMapper.selectEnter(enterDO);
        if(e!=null){
            enterDto.setCode("ACK");
            enterDto.setMsg("不可重复报名");
            return  enterDto;
        }
        else{
            //需要在插入之前查询num数是否已满
            Integer activitesId= enterDO.getActivitesId();
            //需要人数
            ActivitiesDO activitiesDO=activitiesDOMapper.selectNum(activitesId);
            int needNum=activitiesDO.getNum();
            //实际报名人数
            List<EnterDO> enterDOS=enterDOMapper.getNum(activitesId);
            int nowNum=enterDOS.size();
            //需要的人数大于实际报名人数，报名数未满
            if(needNum>nowNum){
                int result =enterDOMapper.insert(enterDO);
                if(result!=0){
                    enterDto.setCode("ACK");
                    enterDto.setMsg("报名成功");
                }else {
                    enterDto.setCode("NACK");
                    enterDto.setMsg("报名失败");
                }
                return  enterDto;
            }else {
                enterDto.setCode("ACK");
                enterDto.setMsg("报名人数已满");
                return  enterDto;
            }
        }
    }
    //取消报名
    @Override
    public EnterDto del(Integer id){
        int result =enterDOMapper.deleteByPrimaryKey(id);
        EnterDto enterDto=new EnterDto();
        if(result!=0){
            enterDto.setCode("ACK");
            enterDto.setMsg("取消报名成功");
        }else {
            enterDto.setCode("NACK");
            enterDto.setMsg("取消报名失败");
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
            enterDto.setCode("ACK");
            enterDto.setData(list);
            enterDto.setMsg("暂无数据");
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
    //获取某个用户参加的活动
    @Override
    public EnterDto getUserTotal(Integer userId){
        List<EnterTotal> list = new ArrayList<EnterTotal>();
        list =enterDOMapper.getUserTotal(userId);
        EnterDto enterDto=new EnterDto();
        if(list.size()!=0){
            enterDto.setCode("ACK");
            enterDto.setMsg("查询成功");
            enterDto.setData(list);
        }else {
            enterDto.setCode("ACK");
            enterDto.setMsg("暂无数据");
        }
        return  enterDto;
    }
    //批量更新
    @Override
    public EnterDto updateAll(List<EnterDO> resultList){
        int result=enterDOMapper.updateAll(resultList);
        EnterDto awardDto=new EnterDto();
        if(result !=-1){
            awardDto.setCode("ACK");
            awardDto.setMsg("更新成功");
        }else {
            awardDto.setCode("NACK");
            awardDto.setMsg("更新失败");
        }
        return  awardDto;
    }

}
