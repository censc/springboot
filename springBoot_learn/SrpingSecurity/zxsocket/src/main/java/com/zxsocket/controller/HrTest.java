package com.zxsocket.controller;

import com.zxsocket.bean.Hr;
import com.zxsocket.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrTest {
    
    @Autowired
    HrService hrService;
    
    @GetMapping("/test")
    public void test(){
    
    }
}
