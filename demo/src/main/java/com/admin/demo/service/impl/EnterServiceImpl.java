package com.admin.demo.service.impl;

import com.admin.demo.dao.EnterDOMapper;
import com.admin.demo.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterServiceImpl implements EnterService {
    @Autowired(required = true)
    private EnterDOMapper enterDOMapper;
}
