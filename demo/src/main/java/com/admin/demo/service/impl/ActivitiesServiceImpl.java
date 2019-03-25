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
        private ActivitiesDOMapper ActivitiesDOMapper;
        @Override
        public ActivitiesDto selectAll(){
             ActivitiesDO u =new ActivitiesDO();
             List<ActivitiesDO> list = new ArrayList<ActivitiesDO>();
             list =ActivitiesDOMapper.selectAll();
             ActivitiesDto ActivitiesDto=new ActivitiesDto();
             if(list.size()!=0){
                 ActivitiesDto.setCode("ACK");
                 ActivitiesDto.setMsg("查询成功");
                 ActivitiesDto.setList(list);
             }else {
                 ActivitiesDto.setCode("NACK");
                 ActivitiesDto.setMsg("查询失败");
             }
             return  ActivitiesDto;
        }
        @Override
        public ActivitiesDto selectById(){
             ActivitiesDO u =new ActivitiesDO();
             u =ActivitiesDOMapper.selectByPrimaryKey(1);
             ActivitiesDto ActivitiesDto=new ActivitiesDto();
             if(u==null){
                 ActivitiesDto.setCode("ACK");
                 ActivitiesDto.setMsg("查询成功");
                 ActivitiesDto.setData(u);
             }else {
                 ActivitiesDto.setCode("NACK");
                 ActivitiesDto.setMsg("查询失败");
             }
             return  ActivitiesDto;
        }
        @Override
        public int publish(){
             ActivitiesDO u =new ActivitiesDO();
             int result =ActivitiesDOMapper.insert(u);
             ActivitiesDto ActivitiesDto=new ActivitiesDto();
             if(result!=0){
                 ActivitiesDto.setCode("ACK");
                 ActivitiesDto.setMsg("发布成功");
             }else {
                 ActivitiesDto.setCode("NACK");
                 ActivitiesDto.setMsg("发布失败");
             }
             return  1;
        }
        @Override
        public int edit(){
            return 1;
        }
}
