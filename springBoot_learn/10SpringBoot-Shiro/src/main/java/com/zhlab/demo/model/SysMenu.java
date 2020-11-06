package com.zhlab.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity // @Entity: 实体类, 必须
@Table(name="sys_menu") //指定表名称
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 4096992355334487966L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue： 表明是否自动生成, 必须, strategy也是必写, 指明主键生成策略, 默认是Oracle
    private Long menuId;

    @Column(name = "menu_name", nullable = false)
    private String menuName;
    private Long parentId;
    private String menuUrl;
    private String perms;
    private Integer sort;
    private Boolean isView;
    private Boolean isLink;
    private Boolean status;
    private Integer menuType;

    @ManyToMany(mappedBy = "menus")
    @JsonIgnore
    private Set<SysRole> roles = new HashSet<>(0);

    @Transient
    @JsonIgnore
    private Map<Long, SysMenu> children = new HashMap<>();

    public SysMenu(){

    }

    public SysMenu(Long id, String menuName) {
        this.menuId = id;
        this.menuName = menuName;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getView() {
        return isView;
    }

    public void setView(Boolean view) {
        isView = view;
    }

    public Boolean getLink() {
        return isLink;
    }

    public void setLink(Boolean link) {
        isLink = link;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }
}
