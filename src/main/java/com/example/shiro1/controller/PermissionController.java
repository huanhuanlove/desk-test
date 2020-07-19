package com.example.shiro1.controller;

import com.example.shiro1.entity.Permission;
import com.example.shiro1.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Permission)表控制层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permission selectOne(int id) {
        return this.permissionService.queryById(id);
    }

}