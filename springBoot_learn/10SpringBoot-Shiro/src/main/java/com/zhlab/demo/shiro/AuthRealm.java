package com.zhlab.demo.shiro;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.model.SysRole;
import com.zhlab.demo.service.SysAdminUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @ClassName AuthRealm
 * @Description //验证授权逻辑
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/5 0005 上午 10:33
 **/
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private SysAdminUserService userService;

    /**
     * 认证逻辑
     * 实现用户认证，通过服务加载用户信息并构造认证对象返回
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getPrincipal().toString();
        SysAdminUser user = userService.getByUserName(name);
        if (user == null)  return null;
        SimpleAuthenticationInfo  info = new SimpleAuthenticationInfo(user,
                user.getPassword(), getName());
        return info;
    }

    /**
     * 授权逻辑
     * 实现权限认证，通过服务加载用户角色和权限信息设置进去
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取获取登录用户Principal对象
        SysAdminUser user = (SysAdminUser) principal.getPrimaryPrincipal();

        // 管理员拥有所有权限
        if (user.getAdminUserId().equals(1L)) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
            return info;
        }

        // 赋予角色和资源授权
        Set<SysRole> roles = ShiroUtil.getSubjectRoles();
        roles.forEach(role -> {
            info.addRole(role.getRoleName());
            role.getMenus().forEach(menu -> {
                String perms = menu.getPerms();
                if (menu.getStatus() && !StringUtils.isEmpty(perms) && !perms.contains("*")) {
                    info.addStringPermission(perms);
                }
            });
        });

        return info;
    }

}
