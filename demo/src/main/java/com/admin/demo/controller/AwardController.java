package com.admin.demo.controller;

import com.admin.demo.data.AwardDO;
import com.admin.demo.dto.AwardDto;
import com.admin.demo.service.AwardService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/award")
public class AwardController {
    @Autowired
    private AwardService awardService;
    //生成星级志愿者，批量生成
     @ResponseBody
     @PostMapping("/make")
     public AwardDto insertAll(@RequestParam(required= false) String info ){
         JSONArray jsonArray=JSONArray.parseArray(info);
         List<AwardDO> list = JSONObject.parseArray(jsonArray.toJSONString(), AwardDO.class);
         return awardService.insertAll(list);

     }
    //根据年份查询
    @ResponseBody
    @GetMapping("/getByYear")
    public AwardDto getByYear(@RequestParam(required= false) Integer year){
        return awardService.getByYear(year);
    }
    //查询学生的荣誉记录
    @ResponseBody
    @GetMapping("/getByUser")
    public AwardDto getByUser(@RequestParam(required= false) Integer id){
        return awardService.getByUser(id);
    }
}
