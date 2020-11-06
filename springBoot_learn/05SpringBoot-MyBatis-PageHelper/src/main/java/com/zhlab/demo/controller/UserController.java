package com.zhlab.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhlab.demo.model.SysAdminUser;
import com.zhlab.demo.service.SysAdminUserService;
import com.zhlab.demo.utils.PageUtil;
import com.zhlab.demo.utils.page.PageRequest;
import com.zhlab.demo.utils.page.PageResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description //用户接口层
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2020/10/31 0031 上午 9:43
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    SysAdminUserService sysAdminUserService;

    /* 方法注解 */
    @ApiOperation(value = "方法名:用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public List<SysAdminUser> list(){
        List<SysAdminUser> list = sysAdminUserService.findAll();

        return list;
    }

    @ApiOperation(value = "方法名:用户列表分页", notes = "获取分页用户列表")
    @PostMapping(value="/findPage")
    public PageResult findPage(@RequestBody PageRequest pageRequest) {

        startPage(pageRequest); //开启分页,pageHelp会自动拦截mybatis的sql
        List<SysAdminUser> list = sysAdminUserService.findAll();
        return PageUtil.getPageResult(new PageInfo<>(list));
    }

    /**
     * 启动分页
     * */
    private void startPage(PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum() == 0?1:pageRequest.getPageNum(),
                pageRequest.getPageSize()==0?5:pageRequest.getPageSize());
    }

}
