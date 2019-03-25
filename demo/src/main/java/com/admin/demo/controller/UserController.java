package com.admin.demo.controller;

import com.admin.demo.data.UserBasicDO;
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
     @GetMapping("/findAll")
     public UserDto findAll(){
         return userService.findAll();
     }
     @ResponseBody
     @PostMapping("/add")
     public UserDto add(HttpServletRequest request, @RequestParam(required= false) String account, @RequestParam String password,@RequestParam int userId){
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
    // @ResponseBody
    // @GetMapping("/findOneInfo")
    // public UserInfoDto findOneInfo(HttpServletRequest request, @RequestParam(required= false) Integer id){
    //     return userService.findOneInfo(id);
    // }
    // @ResponseBody
    // @GetMapping("/findAllInfo")
    // public UserInfoDto findAllInfo(){
    //     return userService.findAllInfo();
    // }
}
