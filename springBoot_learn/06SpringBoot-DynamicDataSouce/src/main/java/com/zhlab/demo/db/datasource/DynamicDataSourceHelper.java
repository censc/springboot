package com.zhlab.demo.db.datasource;


/**
 * @ClassName DynamicDataSource
 * @Description //数据源切换处理
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/11/2 0002 下午 2:22
 **/
public class DynamicDataSourceHelper
{

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源的变量
     */
    public static void setDataSourceType(String dsType) { CONTEXT_HOLDER.set(dsType); }

    /**
     * 获得数据源的变量
     */
    public static String getDataSourceType() { return CONTEXT_HOLDER.get(); }

    /**
     * 清空数据源变量
     */
    public static void clearDataSourceType()
    {
        CONTEXT_HOLDER.remove();
    }
}
