package com.admin.demo.service.impl;

import com.admin.demo.dao.RuleDOMapper;
import com.admin.demo.data.RuleDO;
import com.admin.demo.dto.RuleDto;
import com.admin.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired(required = true)
    private RuleDOMapper ruleDOMapper;
    //更新规则信息
    @Override
    public RuleDto updateRule(RuleDO ruleDO) {
        int result = ruleDOMapper.updateByPrimaryKeySelective(ruleDO);
        RuleDto ruleDto = new RuleDto();
        if (result != 0) {
            ruleDto.setCode("ACK");
            ruleDto.setMsg("更新成功");
        } else {
            ruleDto.setCode("NACK");
            ruleDto.setMsg("更新失败");
        }
        return  ruleDto;
    }
    //获取规则信息
    @Override
     public RuleDto getRule(Integer ruleId) {
        RuleDO ruleDO=new RuleDO();
         ruleDO = ruleDOMapper.selectByPrimaryKey(ruleId);
         RuleDto ruleDto = new RuleDto();
         if (ruleDO != null) {
             ruleDto.setCode("ACK");
             ruleDto.setMsg("查询成功");
         } else {
             ruleDto.setCode("NACK");
             ruleDto.setMsg("查询失败");
         }
         return  ruleDto;
     }

}
