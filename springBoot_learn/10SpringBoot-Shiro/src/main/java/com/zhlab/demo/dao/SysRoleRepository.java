package com.zhlab.demo.dao;

import com.zhlab.demo.model.SysAdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface SysRoleRepository extends JpaRepository<SysAdminUser,Long>, Serializable {


    Boolean existsByAdminUserId(Long userId);
}
