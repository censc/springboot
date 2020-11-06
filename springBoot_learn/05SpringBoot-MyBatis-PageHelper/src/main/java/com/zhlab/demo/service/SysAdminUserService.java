package com.zhlab.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhlab.demo.mapper.SysAdminUserMapper;
import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.utils.PageUtil;
import com.zhlab.demo.utils.page.PageRequest;
import com.zhlab.demo.utils.page.PageResult;
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
    SysAdminUserMapper sysAdminUserMapper;

    /**
     * 查询所有用户
     * */
    public List<SysAdminUser> findAll(){
        return sysAdminUserMapper.selectAll();
    }

}
