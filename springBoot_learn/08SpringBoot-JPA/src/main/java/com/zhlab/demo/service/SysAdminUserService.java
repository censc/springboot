package com.zhlab.demo.service;

import com.zhlab.demo.dao.SysAdminUserRepository;
import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.utils.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
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

}
