package com.zhlab.demo.dao;

import com.zhlab.demo.model.SysAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName SysAdminUserRepository
 * @Description //SysAdminUserRepository
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 下午 2:45
 **/
@Repository
public class SysAdminUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 新增用户
     */
    public void save(SysAdminUser user) {
        String sql = "insert into sys_admin_user(admin_user_id, user_name, password, nick_name, dept_id, phone, email) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                user.getAdminUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getNickName(),
                user.getDeptId(),
                user.getPhone(),
                user.getEmail());
    }

    /**
     * 删除用户
     */
    public void delete(Long id) {
        String sql = "delete from sys_admin_user where admin_user_id=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 查询全部用户
     */
    public List<SysAdminUser> findAll() {
        String sql = "select * from sys_admin_user order by admin_user_id desc";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SysAdminUser.class));
    }

}
