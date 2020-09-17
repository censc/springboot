package com.single.zxcloud.controller;

import com.single.zxcloud.domain.CommonResult;
import com.single.zxcloud.domain.User;
import com.single.zxcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Value("${server.port}")
    private String port;
    
    @Autowired
    private  UserService userService;
    
    @GetMapping("/{id}")
    public CommonResult<User> index(@PathVariable Long id){
        //System.out.println(id);
        User u = userService.getUser(id);
        return new CommonResult<>(u);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user){
        userService.create(user);
        return new CommonResult("操作成功",200);
    }
    
    @ResponseBody
    @GetMapping("/port")
    public String port(){
        return port;
    }
    
}
