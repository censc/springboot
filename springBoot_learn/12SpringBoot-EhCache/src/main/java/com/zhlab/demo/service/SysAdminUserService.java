package com.zhlab.demo.service;

import com.zhlab.demo.dao.SysAdminUserRepository;
import com.zhlab.demo.model.SysAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysAdminUserService
 * @Description //SysAdminUserService
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 9:45
 **/
@CacheConfig(cacheNames = "users")
@Service
public class SysAdminUserService {

    @Autowired
    SysAdminUserRepository sysAdminUserRepository;


    @Cacheable(key="'user_'+#userId")
    public SysAdminUser findUser(Long userId){
        return sysAdminUserRepository.findById(userId).orElse(null);
    }

    @CachePut(key="'user_'+#result.adminUserId")
    public SysAdminUser save(SysAdminUser user){
        return sysAdminUserRepository.save(user);
    }

    @CacheEvict(key="'user_'+#userId")
    public void deleteUser(Long userId) {
        sysAdminUserRepository.findById(userId).ifPresent(sysAdminUserRepository::delete);
    }
}
