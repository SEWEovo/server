package com.admin.demo.controller;

import com.admin.demo.data.EnterDO;
import com.admin.demo.dto.EnterDto;
import com.admin.demo.service.EnterService;
import com.admin.demo.service.RuleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enter")
public class EnterController {
    @Autowired
    private EnterService enterService;
    //用户报名
    @ResponseBody
    @PostMapping("/insertOne")
    public EnterDto insertOne(@RequestParam(required= false) String info){
        EnterDO enterDO = JSON.parseObject(info, EnterDO.class);
        return enterService.insertOne(enterDO);
    }
    //用户取消报名
    @ResponseBody
    @PostMapping("/delOne")
    public EnterDto delOne(@RequestParam(required= false) Integer id){
        return enterService.del(id);
    }
    //获取某个活动的报名情况 多张表
    @ResponseBody
    @GetMapping("/getByActivity")
    public EnterDto getByActivity(@RequestParam(required= false) Integer activitesId){
        return enterService.getByActivity(activitesId);
    }
    //获取某个用户参加的活动 多张表
    @ResponseBody
    @GetMapping("/getByUser")
    public EnterDto getByUser(@RequestParam(required= false) Integer userId){
        return enterService.getByUser(userId);
    }
    //批量更新用户某活动的参与情况(参与状态、得分、时长)
    @ResponseBody
    @PostMapping("/updateAll")
    public EnterDto updateAll(@RequestParam(required= false) String info ){
        JSONArray jsonArray=JSONArray.parseArray(info);
        List<EnterDO> list = JSONObject.parseArray(jsonArray.toJSONString(), EnterDO.class);
        return enterService.updateAll(list);
    }
    //获取某个用户每年的志愿记录
    @ResponseBody
    @GetMapping("/getUserTotal")
    public EnterDto getUserTotal(@RequestParam(required= false) Integer userId){
        return enterService.getUserTotal(userId);
    }
}
