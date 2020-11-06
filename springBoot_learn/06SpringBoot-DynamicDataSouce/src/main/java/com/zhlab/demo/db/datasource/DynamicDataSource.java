package com.zhlab.demo.db.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName DynamicDataSource
 * @Description //DynamicDataSource
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/2 0002 下午 2:22
 **/
public class DynamicDataSource extends AbstractRoutingDataSource
{
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources)
    {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();

    }

    @Override
    protected Object determineCurrentLookupKey()
    {
        return DynamicDataSourceHelper.getDataSourceType();
    }
}
