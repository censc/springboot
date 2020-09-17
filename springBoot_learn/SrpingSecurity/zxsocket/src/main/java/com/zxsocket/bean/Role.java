package com.zxsocket.bean;

import java.io.Serializable;

public class Role implements Serializable {
    
    private static final long serialVersionUID = -6112006540996224112L;
    private long id;
    private String name;
    private String nameZh;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNameZh() {
        return nameZh;
    }
    
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
