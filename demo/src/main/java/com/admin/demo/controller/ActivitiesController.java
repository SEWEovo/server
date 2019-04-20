package com.admin.demo.controller;

import com.admin.demo.data.ActivitiesDO;
import com.admin.demo.dto.ActivitiesDto;
import com.admin.demo.service.ActivitiesService;
import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Activities")
public class ActivitiesController {
    @Autowired
    private ActivitiesService ActivitiesService;
    @ResponseBody
    @PostMapping("/publish")
    public ActivitiesDto publish(@RequestParam(required= false) String  activity){
        ActivitiesDO activitiesDO = JSON.parseObject(activity, ActivitiesDO.class);
        return ActivitiesService.publish(activitiesDO);
    }
    @ResponseBody
    @PostMapping("/edit")
    public ActivitiesDto edit(@RequestParam(required= false) String  activity){
        ActivitiesDO activitiesDO = JSON.parseObject(activity, ActivitiesDO.class);
        return ActivitiesService.edit(activitiesDO);
    }
    //可以获取单个或者多个 暂时为根据状态查询 修改参数即可
    @ResponseBody
    @GetMapping("/getAll")
    public ActivitiesDto getAll(@RequestParam(required= false) Integer id, @RequestParam(required= false) Integer status){
        ActivitiesDO activitiesDO=new ActivitiesDO();
        if(id!=null){
            activitiesDO.setActivitesId(id);
        }
        if(status!=null){
            activitiesDO.setStatus(status);
        }
         return ActivitiesService.selectAll(activitiesDO);
    }
    //可以获取单个或者多个 暂时为根据状态查询 修改参数即可
    @ResponseBody
    @GetMapping("/selectByPublish")
    public ActivitiesDto selectByPublish(@RequestParam(required= false) Integer userId){
        ActivitiesDO activitiesDO=new ActivitiesDO();
        activitiesDO.setUserId(userId);
        return ActivitiesService.selectByPublish(activitiesDO);
    }
    @ResponseBody
    @GetMapping("/getLast")
    public ActivitiesDto getLast(@RequestParam(required= false) Integer userId){
      return ActivitiesService.getLast(userId);
    }

    @ResponseBody
    @PostMapping("/updateStatus")
    public ActivitiesDto updateStatus(@RequestParam(required= false) Integer id){
        return ActivitiesService.updateStatus(id);
    }
}
