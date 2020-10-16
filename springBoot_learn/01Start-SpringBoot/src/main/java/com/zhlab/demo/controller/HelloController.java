package com.zhlab.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description //第一个Springboot接口
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/16 0016 上午 10:55
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "I can say hello";
    }
}
