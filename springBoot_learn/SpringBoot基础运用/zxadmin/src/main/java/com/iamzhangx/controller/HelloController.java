package com.iamzhangx.controller;

import com.iamzhangx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloController {
    
    @GetMapping("/bk")
    public Book book(){
    
        Book bk = new Book();
        bk.setName("童话故事");
        bk.setAuthor("安徒生");
        bk.setPrice(new BigDecimal(50.00));
        return bk;
    }
    
    @GetMapping("/hello")
    public String hello(){
        return "this is a test";
    }
}
