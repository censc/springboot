package com.iamzhangx.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //静态资源目录配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/asset/**")
                .addResourceLocations("classpath:/asset/");
        registry
                .addResourceHandler("/public/**")
                .addResourceLocations("classpath:/public/");
    }
    
    //跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/user/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://127.0.0.1:8099");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
    
    }
    
}
