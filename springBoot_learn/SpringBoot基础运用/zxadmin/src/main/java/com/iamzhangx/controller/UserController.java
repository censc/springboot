package com.iamzhangx.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iamzhangx.service.UserService;
import com.iamzhangx.bean.SysUser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {


    @Autowired
    UserService userService;
    
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    
    @GetMapping(value = "/user/{id}")
    public SysUser getUser(@PathVariable Integer id){
        System.out.println(id);
        return userService.getUserById(id);
    }
    
    @GetMapping(value = "/upu/{id}")
    public int updateUser(@PathVariable Integer id){
        SysUser su = new SysUser();
        su.setNickName("zxzxzx");
        su.setUserId(id);
        return userService.updateUser(su);
    }
    
    @GetMapping(value = "/userm/{id}")
    public SysUser getUserm(@PathVariable Integer id){
        System.out.println(id);
        return userService.getUserById(id);
    }
    

    @GetMapping(value = "/reuser/{id}")
    public void getRedisReturn(@PathVariable Integer id) throws JsonProcessingException, IOException, JsonParseException, JsonMappingException {
    
        ValueOperations<String,String> vop = stringRedisTemplate.opsForValue();
        vop.set("user_name","admin");
        String name = vop.get("user_name");
        System.out.println("name="+name);
        ValueOperations vop2 = redisTemplate.opsForValue();
        SysUser su = new SysUser();
        su.setNickName("zxzxzx");
        su.setUserId(1);
        su.setUserName("admin");
        su.setEmail("admin@163.com");
        vop2.set("bx",su);
        Object bb = vop2.get("bx");
        
        ObjectMapper mp = new ObjectMapper();
       String bbx = mp.writeValueAsString(bb);
        System.out.println( bbx);
        vop2.set("bbx",bbx);
        // json 转 obje ObjectMapper mapper = new ObjectMapper(); mapper.readValue(jsonStr, obj.getClass());
        SysUser su2 = su;
        su2 = mp.readValue(bbx,su.getClass());
        System.out.println(su2);
    }
    
}
