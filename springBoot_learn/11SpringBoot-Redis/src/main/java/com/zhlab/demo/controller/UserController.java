package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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

    private static final int expireTime = 30;

    @Autowired
    SysAdminUserService sysAdminUserService;

    @Autowired
    RedisTemplate redisTemplate;


    @ApiOperation(value = "方法名:用户信息", notes = "获取用户信息")
    @GetMapping("/{userId}")
    public SysAdminUser findUser(@PathVariable Long userId){

        //从缓存获取有无这个用户信息
        SysAdminUser userInfo = getCacheObject("users::user_"+userId);
        if(userInfo == null){
            //没有,则从数据库查询
            userInfo =sysAdminUserService.findUser(userId);

            //设置缓存
            setCacheObject("users::user_"+userId,userInfo,expireTime,TimeUnit.MINUTES);
        }
        return sysAdminUserService.findUser(userId);
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


    /**
     * 获取缓存
     * */
    private <T> T getCacheObject(String key)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 设置缓存
     * */
    private <T> ValueOperations<String, T> setCacheObject(String key, T value, Integer timeout, TimeUnit timeUnit)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, timeout, timeUnit);
        return operation;
    }
}
