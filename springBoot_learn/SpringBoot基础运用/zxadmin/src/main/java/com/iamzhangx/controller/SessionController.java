package com.iamzhangx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/ss")
public class SessionController {
    
    @Value("${server.port}")
    String port;
    
    @GetMapping("/save")
    public String saveData(String name, HttpSession session){
        session.setAttribute("test_name","zxzxzxzx");
        return port;
    }
    
    @GetMapping("/get")
    public String getData(HttpSession session){
        return port + session.getAttribute("test_name").toString();
    }
    
}
