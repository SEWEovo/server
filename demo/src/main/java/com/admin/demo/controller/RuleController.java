package com.admin.demo.controller;

import com.admin.demo.data.RuleDO;
import com.admin.demo.dto.RuleDto;
import com.admin.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    private RuleService ruleService;
    @ResponseBody
    @PostMapping("/num")
    public RuleDto update(@RequestParam(required= false) Integer num1, @RequestParam Integer num2,@RequestParam Integer num3){
        RuleDO ruleDO=new RuleDO();
        ruleDO.setNum1(num1);
        ruleDO.setNum2(num2);
        ruleDO.setNum3(num3);
        ruleDO.setRuleId(1);
        return ruleService.updateRule(ruleDO);
    }
    @ResponseBody
    @PostMapping("/rule")
    public RuleDto updateRule(@RequestParam(required= false) Integer count, Integer totaltime,Integer evaluate){
        RuleDO ruleDO=new RuleDO();
        ruleDO.setCount(count);
        ruleDO.setTotaltime(totaltime);
        ruleDO.setEvaluate(evaluate);
        ruleDO.setRuleId(1);
        return ruleService.updateRule(ruleDO);
    }
    @ResponseBody
    @GetMapping("/getRule")
    public RuleDto getRule(){
        Integer id=1;
        return ruleService.getRule(id);
    }
}
