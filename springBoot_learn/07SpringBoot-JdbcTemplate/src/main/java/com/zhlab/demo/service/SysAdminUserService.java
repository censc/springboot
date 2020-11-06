package com.zhlab.demo.service;

import com.zhlab.demo.dao.SysAdminUserRepository;
import com.zhlab.demo.model.SysAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysAdminUserService
 * @Description //TODO
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 9:45
 **/
@Service
public class SysAdminUserService {

    @Autowired
    SysAdminUserRepository sysAdminUserRepository;

    /**
     * 新增用户
     * */
    public void addUser(SysAdminUser user){
        sysAdminUserRepository.save(user);
    }

    /**
     * 查询所有用户
     * */
    public List<SysAdminUser> findAll(){
        return sysAdminUserRepository.findAll();
    }

}
