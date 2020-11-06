package com.zhlab.demo.mapper;


import com.zhlab.demo.model.SysAdminUser;

import java.util.List;

public interface SysAdminUserMapper {
    int insert(SysAdminUser record);

    /**
     * 查询所有用户
     * */
    List<SysAdminUser> selectAll();

    /**
     * 分页查询用户
     */
    List<SysAdminUser> selectPage();
}