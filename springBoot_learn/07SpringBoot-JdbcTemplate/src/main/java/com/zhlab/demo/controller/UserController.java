package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "方法名:新增用户", notes = "新增用户")
    @PostMapping("/add")
    public void add(@RequestBody SysAdminUser user){
        sysAdminUserService.addUser(user);
    }



}
