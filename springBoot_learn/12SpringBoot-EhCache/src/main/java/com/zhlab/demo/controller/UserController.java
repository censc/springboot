package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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

    @Autowired
    private CacheManager cacheManager;


    @ApiOperation(value = "方法名:用户信息", notes = "获取用户信息")
    @GetMapping("/{userId}")
    public SysAdminUser findUser(@PathVariable Long userId){

        // 查看一下CacheManager是否已经是EhCacheCacheManager
        System.out.println("CacheManager type : " + cacheManager.getClass());

        // 查询用户信息的时候,有无sql检索
        SysAdminUser userInfo =sysAdminUserService.findUser(userId);
        return userInfo;
    }

    @ApiOperation(value = "方法名:新增用户", notes = "新增用户")
    @PostMapping("/add")
    public SysAdminUser addUser(@RequestBody SysAdminUser user){
        return sysAdminUserService.save(user);
    }

    @ApiOperation(value = "方法名:删除用户信息", notes = "删除用户信息")
    @GetMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){

        sysAdminUserService.deleteUser(userId);
    }
}
