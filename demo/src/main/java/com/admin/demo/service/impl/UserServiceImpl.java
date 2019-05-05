package com.admin.demo.service.impl;
import com.admin.demo.dao.UserBasicDOMapper;
import com.admin.demo.dao.UserBasicWithInfoMapper;
import com.admin.demo.dao.UserInfoDOMapper;
import com.admin.demo.data.UserBasicDO;
import com.admin.demo.data.UserBasicWithInfoDO;
import com.admin.demo.data.UserInfoDO;
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
    @Autowired(required = true)
    private  UserInfoDOMapper userInfoDOMapper;
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
    //后台管理中心登录
    @Override
    public UserDto loginAdmin(String account,String password,Integer type){
        UserBasicDO u =userBasicDOMapper.login(account,password);
        UserDto userDto=new UserDto();
        if(u!=null&& u.getType()!=0){
            userDto.setCode("ACK");
            userDto.setData(u);
            userDto.setMsg("登录成功");
        }else {
            userDto.setCode("NACK");
            userDto.setMsg("没有权限访问");
        }
        return  userDto;
    }
    //授予权限
     @Override
     public UserDto add(UserBasicDO userBasicDO){
        int result= userBasicDOMapper.updateByPrimaryKey(userBasicDO);
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
            userDto.setCode("ACK");
            userDto.setMsg("暂无数据");
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
            userDto.setCode("ACK");
            userDto.setMsg("暂无数据");
        }
        return  userDto;
    }
    //获取单个用户基本信息
    @Override
    public UserDto selectInfo(Integer userId){
        UserInfoDO userInfoDO=new UserInfoDO();
        userInfoDO =userInfoDOMapper.selectByPrimaryKey(userId);
        UserDto userDto=new UserDto();
        if(userInfoDO!=null){
            userDto.setCode("ACK");
            userDto.setMsg("查询成功");
            userDto.setData(userInfoDO);
        }else {
            userDto.setCode("NACK");
            userDto.setMsg("用户不存在");
        }
        return  userDto;
    }
    //授予权限
    @Override
    public UserDto updateInfo(UserInfoDO userInfoDO){
        int result= userInfoDOMapper.updateByPrimaryKey(userInfoDO);
        UserDto userDto=new UserDto();
        if(result != 0){
            userDto.setCode("ACK");
            userDto.setMsg("修改成功");
        }else{
            userDto.setCode("NACK");
            userDto.setMsg("修改失败");
        }
        return  userDto;
    }

    @Override
    public UserDto selectById(Integer userId){
        List<UserBasicWithInfoDO> list=new ArrayList<>();
        list=userBasicWithInfoMapper.selectById(userId);
        UserDto userDto=new UserDto();
        if(list.size() != 0){
            userDto.setCode("ACK");
            userDto.setData(list);
            userDto.setMsg("查询成功");
        }else{
            userDto.setCode("ACK");
            userDto.setMsg("暂无数据");
        }
        return  userDto;
    }

}
