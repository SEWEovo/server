package com.admin.demo.service.impl;

import com.admin.demo.dao.AwardDOMapper;
import com.admin.demo.data.AwardDO;
import com.admin.demo.dto.AwardDto;
import com.admin.demo.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
 public class AwardServiceImpl implements AwardService {
     @Autowired(required = true)
     private AwardDOMapper awardDOMapper;
     @Override
     public AwardDto getByYear(Integer year){
         List<AwardDO> list=new ArrayList<>();
         list=awardDOMapper.selectByPrimaryKey(year);
         AwardDto awardDto=new AwardDto();
         if(list.size()!=0){
             awardDto.setCode("ACK");
             awardDto.setData(list);
             awardDto.setMsg("查询成功");
         }else {
             awardDto.setCode("ACK");
         }
         return  awardDto;
     }
    @Override
    public AwardDto getByUser(Integer id){
        List<AwardDO> list=new ArrayList<>();
        list=awardDOMapper.selectByUser(id);
        System.out.println(list);
        AwardDto awardDto=new AwardDto();
        if(list.size()!=0){
            awardDto.setCode("ACK");
            awardDto.setData(list);
            awardDto.setMsg("查询成功");
        }else {
            awardDto.setCode("NACK");
        }
        return  awardDto;
    }
     @Override
     public AwardDto insertAll(List<AwardDO> resultList){
         int result=awardDOMapper.insertAll(resultList);
         AwardDto awardDto=new AwardDto();
         if(result !=-1){
             awardDto.setCode("ACK");
             awardDto.setMsg("生成成功");
         }else {
             awardDto.setCode("NACK");
             awardDto.setMsg("生成失败");
         }
         return  awardDto;
     }
 }
