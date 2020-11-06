package com.zhlab.demo.controller;

import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description //用户接口层
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 9:43
 **/
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    SysAdminUserService sysAdminUserService;


    @GetMapping("/{userId}")
    public String findUser(@PathVariable Long userId, Model model){



        // 查询用户信息的时候,有无sql检索
        SysAdminUser userInfo =sysAdminUserService.findUser(userId);
        model.addAttribute("title","用户信息详情");
        model.addAttribute("userInfo",userInfo);
        return "/user/info";
    }
}
