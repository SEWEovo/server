package com.admin.demo.controller;

import com.admin.demo.dto.AwardDto;
import com.admin.demo.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/award")
public class AwardController {
    @Autowired
    private AwardService awardService;
    //生成星级志愿者，批量生成
    // @ResponseBody
    // @PostMapping("/make")
    // public AwardDto insertAll(@RequestParam(required= false) String info){
    //     List<AwardDO> awardDO = JSON.parseObject(info, AwardDO.class);
    //     return awardService.insertAll(awardDO);
    // }
    //根据年份查询
    @ResponseBody
    @GetMapping("/getByYear")
    public AwardDto getByYear(@RequestParam(required= false) Integer year){
        return awardService.getByYear(year);
    }
}
