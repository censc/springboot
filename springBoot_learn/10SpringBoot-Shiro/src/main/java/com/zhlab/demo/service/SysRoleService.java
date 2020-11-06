package com.zhlab.demo.service;

import com.zhlab.demo.dao.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysRoleService
 * @Description //SysRoleService
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/5 0005 上午 10:37
 **/
@Service
public class SysRoleService {


    @Autowired
    private SysRoleRepository sysRoleRepository;


    /**
     * 判断指定的用户是否存在角色
     * @param id 用户ID
     */
    public Boolean existsUserOk(Long id) {
        return sysRoleRepository.existsByAdminUserId(id);
    }

}
