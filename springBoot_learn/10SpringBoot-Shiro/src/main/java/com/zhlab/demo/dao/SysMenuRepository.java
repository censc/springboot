package com.zhlab.demo.dao;

import com.zhlab.demo.model.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface SysMenuRepository extends JpaRepository<SysMenu,Long>, Serializable {
}
