package com.admin.demo.controller;

import com.admin.demo.data.UserBasicDO;
import com.admin.demo.dto.UserDto;
import com.admin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/login")
    public UserDto login(HttpServletRequest request, @RequestParam(required= false) String account, @RequestParam String password){
        return userService.login(account,password);
    }
}
