package com.admin.demo.service;

import com.admin.demo.data.RuleDO;
import com.admin.demo.dto.RuleDto;

public interface RuleService {
    RuleDto updateRule(RuleDO ruleDO);
    RuleDto getRule(Integer ruleId);
}
