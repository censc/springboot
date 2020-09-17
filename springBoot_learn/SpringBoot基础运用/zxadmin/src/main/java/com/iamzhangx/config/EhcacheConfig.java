package com.iamzhangx.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class EhcacheConfig {

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean cacheManagerFac = new EhCacheManagerFactoryBean();
        cacheManagerFac.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cacheManagerFac.setShared(true);
        return cacheManagerFac;
    }
    
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean eBean){
        return new EhCacheCacheManager(eBean.getObject());
    }
    
}
