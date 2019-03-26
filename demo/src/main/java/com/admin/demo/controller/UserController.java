package com.admin.demo.controller;

import com.admin.demo.data.UserBasicDO;
import com.admin.demo.data.UserInfoDO;
import com.admin.demo.dto.UserDto;
import com.admin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
     @ResponseBody
     @GetMapping("/selectPermissionStudent")
     public UserDto selectPermissionStudent(){
         return userService.selectPermissionStudent();
     }
    @ResponseBody
    @GetMapping("/selectAll")
    public UserDto selectAll(){
        return userService.selectAll();
    }
     @ResponseBody
     @PostMapping("/add")
     public UserDto add(HttpServletRequest request, @RequestParam(required= false) int userId){
        UserBasicDO userBasicDO=new UserBasicDO();
        userBasicDO.setType(1);
        userBasicDO.setUserId(userId);
         return userService.add(userBasicDO);
     }
     @ResponseBody
     @PostMapping("/del")
     public UserDto del(HttpServletRequest request, @RequestParam(required= false) int userId){
         UserBasicDO userBasicDO=new UserBasicDO();
         userBasicDO.setType(0);
         userBasicDO.setUserId(userId);
         return userService.del(userBasicDO);
     }
     @ResponseBody
    @GetMapping("/findOneInfo")
    public UserDto findOneInfo(HttpServletRequest request, @RequestParam(required= false) Integer userId){
        return userService.selectInfo(userId);
    }
    @ResponseBody
    @PostMapping("/updateInfo")
    public UserDto updateInfo(HttpServletRequest request, @RequestParam(required= false) Integer userId,@RequestParam(required= false) String phone){
        UserInfoDO userInfoDO=new UserInfoDO();
        userInfoDO.setUserId(userId);
        userInfoDO.setPhone(phone);
        return userService.updateInfo(userInfoDO);
    }

}
