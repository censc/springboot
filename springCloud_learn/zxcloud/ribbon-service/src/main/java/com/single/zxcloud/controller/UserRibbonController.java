package com.single.zxcloud.controller;

import com.single.zxcloud.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Autowired
    RestTemplate restTemplate;
    
    @Value("${service-url.user-service}")
    private String userServiceUrl;
    
    private static final String URL = "http://USER-SERVICE";
    
    @RequestMapping("/{id}")
    @ResponseBody
    public CommonResult  getUser(@PathVariable Long id){
        String uri = URL + "/user/"+id;
        return restTemplate.getForObject(uri,CommonResult .class);
    }
    
    @RequestMapping("/port")
    @ResponseBody
    public String getPort() {
        return restTemplate.getForObject(URL + "/user/port", String.class);
    }
    
}
