package com.admin.demo.controller;

import com.admin.demo.data.EnterDO;
import com.admin.demo.dto.EnterDto;
import com.admin.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enter")
public class EnterController {
    @Autowired
    private RuleService ruleService;
    @ResponseBody
    @PostMapping("/getOne")
    public EnterDto getOne(@RequestParam(required= false) Integer num1, @RequestParam Integer num2, @RequestParam Integer num3){
        EnterDto a =new EnterDto();
//        EnterDO enterDO=new EnterDO();
//        return RuleService.updateRule(enterDO);
        return  a;
    }
}
