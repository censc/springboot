package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description //用户接口层
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 9:43
 **/
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    SysAdminUserService sysAdminUserService;


    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/add")
    public String addUser(@RequestBody SysAdminUser user) {
        user = sysAdminUserService.save(user);
        return "addUser is ok! \n" + user.toString();
    }

    /**
     * 需要有admin角色才能处理
     * */
    @RequiresRoles("admin")
    @RequiresPermissions("edit")
    @GetMapping(value = "/edit")
    public String edit() {
        return "edit user success!";
    }

}
