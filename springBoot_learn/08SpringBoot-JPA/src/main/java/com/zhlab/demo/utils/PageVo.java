package com.zhlab.demo.utils;

/**
 * @ClassName PageRequest
 * @Description //分页请求参数
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 下午 5:21
 **/
public class PageVo {

    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
