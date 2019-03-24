package com.admin.demo.service.impl;

import com.admin.demo.dao.UserBasicDOMapper;
import com.admin.demo.data.UserBasicDO;
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
    @Override
    public UserDto login(String account,String password){
        UserBasicDO u =new UserBasicDO();
        List<UserBasicDO> list = new ArrayList<UserBasicDO>();
        list =userBasicDOMapper.login(account,password);
        System.out.print(list);
        UserDto userDto=new UserDto();
        if(list.size()!=0){
            userDto.setCode(200);
            userDto.setList(list);
        }else {
            userDto.setCode(800);
        }
        return  userDto;
    }
}
