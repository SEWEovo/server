package com.admin.demo.dao;

import com.admin.demo.data.EnterWithauDO;

import java.util.List;

public interface EnterWithauDOMapper {
    List<EnterWithauDO> selectByActivity(Integer acId);
    List<EnterWithauDO> selectByUser(Integer uId);
//    int update();

}
