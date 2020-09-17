package com.iamzhangx.dao;

import com.iamzhangx.bean.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    
    public int updateUser(SysUser sysUser){
        
        return jdbcTemplate.update("UPDATE sys_user SET nick_name=? WHERE user_id=?",sysUser.getNickName(),sysUser.getUserId());
    }
    
    public SysUser getUserById(Integer id){
        return jdbcTemplate.queryForObject("select * from sys_user where user_id=? ", new BeanPropertyRowMapper<>(SysUser.class),id);
    }
    
}
