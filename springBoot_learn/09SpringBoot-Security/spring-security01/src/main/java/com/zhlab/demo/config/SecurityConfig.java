package com.zhlab.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description //Security配置
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/4 0004 下午 4:23
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //我们这里的密码经过BCryptPasswordEncoder加密,这样
        String pwd = encryptPassword("123123");
        auth.inMemoryAuthentication()
                .withUser("singleZhang")
                .password(pwd).roles("admin");
    }

    /**
     * 加密
     * */
    private static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
