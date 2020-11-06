package com.zhlab.demo.dao;

import com.zhlab.demo.model.SysAdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface SysAdminUserRepository extends JpaRepository<SysAdminUser,Long>, Serializable {
    // 就这么简单?
    // 对,就这么简单,什么都不用写,这是Spring Data JPA 默认帮我们实现了基本的数据库操作
    // 如果需要扩展,可以自定义符合Spring Data JPA规则的查询方法，由框架将其自动解析为SQL
    SysAdminUser findByUserName(String userName);
}
