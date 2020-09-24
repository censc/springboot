package com.single.zxblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ZxblogApplication{
    
    public static void main(String[] args) {
        SpringApplication.run(ZxblogApplication.class, args);
    }
    
/*    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZxblogApplication.class);
    }*/
}
