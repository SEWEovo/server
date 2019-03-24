package com.admin.demo.service;


import com.admin.demo.data.UserBasicDO;
import com.admin.demo.dto.UserDto;

public interface UserService {
    UserDto login(String account,String password);

}
