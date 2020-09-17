package com.iamzhangx.mapper;

import com.iamzhangx.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;

import javax.management.relation.Role;
import java.util.List;

@Mapper
public interface UserMapper {
    SysUser loadUserByUsername(String username);
    int updateUserById(SysUser sysUser);
    SysUser getUserById(Integer id);
    List<SysUser> uList();
    
    List<Role> getUserRolesById(Integer id);
}
