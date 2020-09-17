package com.iamzhangx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SecutiryController {


    @GetMapping("/te")
    public String hisecurity(){
        return "test";
    }
    
    @GetMapping("/admin")
    public String atest(){
        
        return "admin";
    }
    
    @GetMapping("/dba")
    public String btest(){
        return "dba";
    }
    
    @GetMapping("/user")
    public  String Ctest(){
        return "user";
    }
    
    @PostMapping("/login")
    public String login(HttpServletRequest rest){
        System.out.println(rest);
        return "";
    }
}
