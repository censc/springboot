package com.iamzhangx.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SysRole implements Serializable {

    private Integer roleId;
    private String roleName;
    private String roleKey;
    
    public Integer getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleKey() {
        return roleKey;
    }
    
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }
}
