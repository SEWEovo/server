package com.admin.demo.controller;

import com.admin.demo.data.UserBasicDO;
import com.admin.demo.data.UserInfoDO;
import com.admin.demo.dto.UserDto;
import com.admin.demo.dto.VolunteerScoreStatisticsDTO;
import com.admin.demo.result.ResultDO;
import com.admin.demo.service.UserService;
import com.admin.demo.service.VolunteerScoreStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VolunteerScoreStatisticsService volunteerScoreStatisticsService;
    @ResponseBody
    @PostMapping("/login")
    public UserDto login(HttpServletRequest request, @RequestParam(required= false) String account, @RequestParam String password){
        return userService.login(account,password);
    }
    //后台中心登录
    @ResponseBody
    @PostMapping("/loginAdmin")
    public UserDto loginAdmin(HttpServletRequest request, @RequestParam(required= false) String account, @RequestParam String password){
        Integer type=1;
        return userService.loginAdmin(account,password,1);
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
    @ResponseBody
    @GetMapping("/getTotal")
    public ResultDO<List<VolunteerScoreStatisticsDTO>> getTotal(String year){
        return volunteerScoreStatisticsService.queryVolunteerScopreStatistics(year);
    }
}
