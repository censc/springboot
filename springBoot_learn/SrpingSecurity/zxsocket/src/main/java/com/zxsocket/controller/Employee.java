package com.zxsocket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/basic")
public class Employee {
    
    @GetMapping("/hello")
    public void hello(){
        System.out.println("test empliyee");
    }
    
}
