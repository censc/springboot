package com.zhlab.demo.service;

import com.zhlab.demo.dao.SysAdminUserRepository;
import com.zhlab.demo.model.SysAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysAdminUserService
 * @Description //SysAdminUserService
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 9:45
 **/
@Service
public class SysAdminUserService {

    @Autowired
    SysAdminUserRepository sysAdminUserRepository;



    public SysAdminUser getByUserName(String username) {
        return sysAdminUserRepository.findByUserName(username);
    }

    public SysAdminUser save(SysAdminUser user){
        return sysAdminUserRepository.save(user);
    }
}
