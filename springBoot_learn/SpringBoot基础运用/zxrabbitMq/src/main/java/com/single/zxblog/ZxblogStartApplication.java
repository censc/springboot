package com.single.zxblog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ZxblogStartApplication extends SpringBootServletInitializer {
    /**
     * 默认返回return super.configure(builder);
     * 现指向ZxblogApplication.main()启动方法
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZxblogApplication.class);
    }
}
