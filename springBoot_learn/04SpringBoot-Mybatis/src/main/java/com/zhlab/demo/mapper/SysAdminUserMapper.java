package com.zhlab.demo.mapper;


import com.zhlab.demo.model.SysAdminUser;

import java.util.List;

public interface SysAdminUserMapper {
    int insert(SysAdminUser record);

    List<SysAdminUser> selectAll();
}