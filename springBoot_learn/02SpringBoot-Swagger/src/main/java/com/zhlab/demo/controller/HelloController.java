package com.zhlab.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Description //第一个Springboot接口
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/16 0016 上午 10:55
 **/
@RestController
@RequestMapping("/system/user")
public class HelloController {

    /* 方法注解 */
    @ApiOperation(value = "方法名:打招呼", notes = "打招呼方法的测试")
    @GetMapping("/hello")
    public String sayHello(/* 参数注解 */ @ApiParam(value = "参数:名字" , required=true ) @RequestParam String name){
        return "hi"+name+",I can say hello";
    }

}
