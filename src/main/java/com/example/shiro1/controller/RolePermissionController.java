package com.example.shiro1.controller;

import com.example.shiro1.entity.RolePermission;
import com.example.shiro1.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RolePermission)表控制层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@RestController
@RequestMapping("rolePermission")
public class RolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private RolePermissionService rolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RolePermission selectOne(int id) {
        return this.rolePermissionService.queryById(id);
    }

}