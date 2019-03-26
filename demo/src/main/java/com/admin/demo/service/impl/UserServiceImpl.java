package com.admin.demo.service.impl;

import com.admin.demo.dao.UserBasicDOMapper;
import com.admin.demo.dao.UserBasicWithInfoMapper;
import com.admin.demo.data.UserBasicDO;
import com.admin.demo.data.UserBasicWithInfoDO;
import com.admin.demo.dto.UserDto;
import com.admin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = true)
    private UserBasicDOMapper userBasicDOMapper;

    @Autowired(required = true)
    private UserBasicWithInfoMapper userBasicWithInfoMapper;
    @Override
    public UserDto login(String account,String password){
       Object u =userBasicDOMapper.login(account,password);
        UserDto userDto=new UserDto();
        if(u!=null){
            userDto.setCode("ACK");
            userDto.setData(u);
            userDto.setMsg("登录成功");
        }else {
            userDto.setCode("NACK");
            userDto.setMsg("账户名或密码错误");
        }
        return  userDto;
    }
    //授予权限
     @Override
     public UserDto add(UserBasicDO userBasicDO){
        int result= userBasicDOMapper.updateByPrimaryKey(userBasicDO);
        System.out.println(result);
         UserDto userDto=new UserDto();
         if(result != 0){
             userDto.setCode("ACK");
             userDto.setMsg("增加成功");
         }else{
             userDto.setCode("NACK");
             userDto.setMsg("增加失败");
         }
         return  userDto;
     }
    //删除权限
     @Override
     public UserDto del(UserBasicDO userBasicDO){
        int result=userBasicDOMapper.updateByPrimaryKey(userBasicDO);

         UserDto userDto=new UserDto();
        if(result != 0){
            userDto.setCode("ACK");
            userDto.setMsg("删除成功");
        }else{
            userDto.setCode("NACK");
            userDto.setMsg("删除失败");
         }
        return  userDto;
     }

    @Override
    public UserDto selectPermissionStudent(){
        List<UserBasicWithInfoDO> list=new ArrayList<>();
        list=userBasicWithInfoMapper.selectPermissionStudent();
        System.out.println(list);
        UserDto userDto=new UserDto();
        if(list.size() != 0){
            userDto.setCode("ACK");
            userDto.setData(list);
            userDto.setMsg("查询成功");
        }else{
            userDto.setCode("NACK");
            userDto.setMsg("查询失败");
        }
        return  userDto;
    }
    //获取权限列表
    @Override
    public UserDto selectAll(){
        List<UserBasicWithInfoDO> list = new ArrayList<>();
        list =userBasicWithInfoMapper.selectAll();
        UserDto userDto=new UserDto();
        if(list.size()!=0){
            userDto.setCode("ACK");
            userDto.setMsg("查询成功");
            userDto.setData(list);
        }else {
            userDto.setCode("NACK");
            userDto.setMsg("查询失败");
        }
        return  userDto;
    }



}
