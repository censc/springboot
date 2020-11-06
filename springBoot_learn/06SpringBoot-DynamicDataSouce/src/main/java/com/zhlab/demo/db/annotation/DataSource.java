package com.zhlab.demo.db.annotation;

import com.zhlab.demo.db.DataSourceType;

import java.lang.annotation.*;

/**
 * 自定义多数据源切换注解
 * 在这里切换数据源名称
 * */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource
{
    DataSourceType value() default DataSourceType.MASTER;
}
