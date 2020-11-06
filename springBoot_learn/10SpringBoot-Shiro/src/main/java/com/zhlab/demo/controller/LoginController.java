package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysRoleService;
import com.zhlab.demo.shiro.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description //登录接口
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/4 0004 下午 5:15
 **/
@RestController
public class LoginController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 登录接口
     * */
    @PostMapping(value = "/login")
    public String login(@RequestBody SysAdminUser user) {
        // 添加用户认证信息
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());

        //获取Subject主体对象
        Subject subject = SecurityUtils.getSubject();
        try {

            subject.login(token);

            // 判断是否拥有后台角色
            SysAdminUser sysAdminUser = ShiroUtil.getSubject();
            if (sysRoleService.existsUserOk(sysAdminUser.getAdminUserId())) {
                return "登录成功";
            } else {
                SecurityUtils.getSubject().logout();
                return "您不是后台管理员";
            }

        } catch (Exception e){
            e.printStackTrace();
            return "用户名或密码错误";
        }

    }

    /**
     * 登出
     * */
    @GetMapping(value = "/logout")
    public String logout() {
        return "logout";
    }

    /**
     * 为授权页面
     * noAuth
     */
    @GetMapping(value = "/noAuth")
    public String noAuth() {
        return "noAuth";
    }
}
