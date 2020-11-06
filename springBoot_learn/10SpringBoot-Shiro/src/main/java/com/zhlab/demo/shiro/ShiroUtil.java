package com.zhlab.demo.shiro;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.model.SysRole;
import com.zhlab.demo.service.SysRoleService;
import org.apache.shiro.SecurityUtils;
import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.BeanUtils;

import java.util.Set;

/**
 * @ClassName ShiroUtil
 * @Description //TODO
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/5 0005 上午 10:33
 **/
public class ShiroUtil {


    /**
     * 获取当前用户角色列表
     */
    public static Set<SysRole> getSubjectRoles() {
        SysAdminUser user = (SysAdminUser) SecurityUtils.getSubject().getPrincipal();

        // 如果用户为空，则返回空列表
        if (user == null) {
            user = new SysAdminUser();
        }

        return user.getRoles();
    }

    /**
     * 获取当前用户对象
     */
    public static SysAdminUser getSubject() {
        SysAdminUser user = (SysAdminUser) SecurityUtils.getSubject().getPrincipal();

        return user;
    }
}
