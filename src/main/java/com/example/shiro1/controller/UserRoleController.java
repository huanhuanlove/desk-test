package com.example.shiro1.controller;

import com.example.shiro1.entity.UserRole;
import com.example.shiro1.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserRole)表控制层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserRole selectOne(int id) {
        return this.userRoleService.queryById(id);
    }

}