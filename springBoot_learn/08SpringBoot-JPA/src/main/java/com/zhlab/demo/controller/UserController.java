package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import com.zhlab.demo.utils.PageVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    /* 方法注解 */
    @ApiOperation(value = "方法名:用户列表分页", notes = "分页获取用户列表")
    @PostMapping("/listForPage")
    public Object listPage(@RequestBody PageVo pageVo){
        Object list = sysAdminUserService.findPage(pageVo);
        return list;
    }

    /* 方法注解 */
    @ApiOperation(value = "方法名:用户列表分页2", notes = "分页获取用户列表2")
    @PostMapping("/listForPageable")
    public Page<SysAdminUser> listPageable(@RequestBody PageVo pageVo){
        Page<SysAdminUser> list = sysAdminUserService.findPageable(pageVo);
        return list;
    }

    @ApiOperation(value = "方法名:新增用户", notes = "新增用户")
    @PostMapping("/add")
    public void add(@RequestBody SysAdminUser user){
        sysAdminUserService.addUser(user);
    }

}
