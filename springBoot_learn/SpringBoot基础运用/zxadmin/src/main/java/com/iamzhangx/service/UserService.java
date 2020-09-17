package com.iamzhangx.service;

import com.iamzhangx.dao.UserDao;
import com.iamzhangx.bean.SysUser;
import com.iamzhangx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;
    
    @Autowired
    UserMapper userMapper;
    
    public SysUser getUserById(Integer id){
        return userDao.getUserById(id);
    }
    
    public int updateUser(SysUser sysUser){
        
        return userDao.updateUser(sysUser);
    }
    
    public SysUser getUserMp(Integer id){
        return userMapper.getUserById(id);
    }
    
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        user.setRoles(userMapper.getUserRolesById(user.getUserId()));
        return user;
    }
    
}
