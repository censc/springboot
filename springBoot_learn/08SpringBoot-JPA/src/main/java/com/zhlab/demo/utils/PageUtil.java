package com.zhlab.demo.utils;

import com.github.pagehelper.PageInfo;
import com.zhlab.demo.utils.page.PageResult;

/**
 * @ClassName PageUtil
 * @Description //分页工具类
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 11:03
 **/
public class PageUtil {

    /**
     * 将分页信息封装到统一的接口
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }


}
