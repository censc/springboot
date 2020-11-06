package com.zhlab.demo.service;

import com.zhlab.demo.dao.SysAdminUserRepository;
import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.utils.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 新增用户
     * */
    public void addUser(SysAdminUser user) {
        sysAdminUserRepository.save(user);
    }

    /**
     * 查询所有用户
     * */
    public List<SysAdminUser> findAll(){
        return sysAdminUserRepository.findAll(Sort.by("adminUserId").descending());
    }

    /**
     * 分页方法1
     * */
    public Object findPage(PageVo pageVo){
        return sysAdminUserRepository.findAll(PageRequest.of(pageVo.getPageNum(),pageVo.getPageSize()));
    }

    /**
     * 分页方法2
     * */
    public Page<SysAdminUser> findPageable(PageVo pageVo){
        Pageable pageable = PageRequest.of(pageVo.getPageNum(), pageVo.getPageSize());

        return sysAdminUserRepository.findAll(pageable);
    }


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
