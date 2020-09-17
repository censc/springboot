package com.iamzhangx.config;

import com.iamzhangx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//
@Configuration
public class WebSecurityConfig  { //extends WebSecurityConfigurerAdapter
    
    
    /*@Autowired
    UserService userService;
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.userDetailsService(userService);
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    

    
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
            .antMatchers("/admin/**")
            .hasRole("admin")
            .antMatchers("/user/**")
            .hasRole("user")
            .antMatchers("/db/**")
            .hasRole("dba")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/asset/login_page.html")
            .loginProcessingUrl("/login")
            .permitAll()
            .and()
            .csrf()
            .disable();
    }*/
}
