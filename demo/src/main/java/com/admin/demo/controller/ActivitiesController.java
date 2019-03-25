package com.admin.demo.controller;

import com.admin.demo.data.ActivitiesDO;
import com.admin.demo.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Activities")
public class ActivitiesController {
    @Autowired
    private ActivitiesService ActivitiesService;
    @ResponseBody
    @PostMapping("/publish")
    public ActivitiesDO publish(){

//         return ActivitiesService.publish();
        ActivitiesDO a=new ActivitiesDO();
        return a;
    }
    @ResponseBody
    @PostMapping("/edit")
    public ActivitiesDO edit(){
        // return ActivitiesService.edit(account,password);
        ActivitiesDO a=new ActivitiesDO();
        return a;
    }
    @ResponseBody
    @GetMapping("/getAll")
    public ActivitiesDO getAll(){
        ActivitiesDO a=new ActivitiesDO();
        return a;
        // return ActivitiesService.getAll(account,password);
    }
    @ResponseBody
    @GetMapping("/getOne")
    public ActivitiesDO getOne(){
        ActivitiesDO a=new ActivitiesDO();
        return a;
        // return ActivitiesService.selectById(account,password);
    }
}
