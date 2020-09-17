package com.zxsocket.mapper;

import com.zxsocket.bean.Hr;
import com.zxsocket.bean.Role;

import java.util.List;

public interface HrMapper {

    
    Hr loadUserByUsername(String s);

    List<Role> getRolesByHrId(Integer id);
}
