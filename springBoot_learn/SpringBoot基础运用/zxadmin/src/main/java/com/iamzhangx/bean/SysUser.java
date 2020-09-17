package com.iamzhangx.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import sun.text.resources.cldr.ti.FormatData_ti_ER;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SysUser implements Serializable, UserDetails {
    
    private static final long serialVersionUID = 877370849183010471L;
    
    private Integer userId;
    private String userName;
    private String password;
    private String nickName;
    private String email;
    

    
    private List<Role> roles;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role r:roles){
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        }
        return authorities;
    }
    
    @Override
    public String getPassword(){
        
        return password;
    }
    
    @Override
    public String getUsername(){
        
        return userName;
    }
    
    @Override
    public boolean isAccountNonExpired(){
        
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked(){
        return false;
    }
    
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    
    @Override
    public boolean isEnabled(){
        return true;
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .toString();
    }
}
