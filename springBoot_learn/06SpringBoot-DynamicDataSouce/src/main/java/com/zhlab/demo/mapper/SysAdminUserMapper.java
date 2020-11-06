package com.zhlab.demo.mapper;


import com.zhlab.demo.db.DataSourceType;
import com.zhlab.demo.db.annotation.DataSource;
import com.zhlab.demo.model.SysAdminUser;

import java.util.List;

public interface SysAdminUserMapper {
    int insert(SysAdminUser record);

    /**
     * 查询所有用户
     * */
    List<SysAdminUser> selectAll();

    @DataSource(value = DataSourceType.SLAVE)
    List<SysAdminUser> selectAll2();

}