package com.zhlab.demo.db.aspect;

import com.zhlab.demo.db.annotation.DataSource;

import com.zhlab.demo.db.datasource.DynamicDataSourceHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName DynamicDataSourceAspect
 * @Description //数据源动态切换AOP
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/2 0002 下午 3:16
 **/
@Aspect
@Order(1)
@Component
public class DynamicDataSourceAspect {

    /**
     * 选择切入点为DataSource注解
     * */
    @Pointcut("@annotation(com.zhlab.demo.db.annotation.DataSource)"
            + "|| @within(com.zhlab.demo.db.annotation.DataSource)")
    public void dsPointCut() { }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource dataSource = getDataSource(point);
        if (dataSource != null) {
            DynamicDataSourceHelper.setDataSourceType(dataSource.value().name());
        }

        try {
            return point.proceed();
        }
        finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceHelper.clearDataSourceType();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    public DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<? extends Object> targetClass = point.getTarget().getClass();
        DataSource targetDataSource = targetClass.getAnnotation(DataSource.class);
        if (targetDataSource != null) {
            return targetDataSource;
        } else {
            Method method = signature.getMethod();
            DataSource dataSource = method.getAnnotation(DataSource.class);
            return dataSource;
        }
    }
}
