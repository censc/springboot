package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /* 方法注解 */
    @ApiOperation(value = "方法名:用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public List<SysAdminUser> list(){
        List<SysAdminUser> list = sysAdminUserService.findAll();

        return list;
    }

}
