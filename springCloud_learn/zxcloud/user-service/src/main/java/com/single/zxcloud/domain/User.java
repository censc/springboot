package com.single.zxcloud.domain;

import org.springframework.stereotype.Component;

@Component
public class User {

    private Long id;
    private String username;
    private String password;
    
    public User() {
    }
    
    public User(Long id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return username;
    }
    
    public void setUserName(String name) {
        this.username = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
