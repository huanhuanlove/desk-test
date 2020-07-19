package com.example.shiro1.controller;

import com.example.shiro1.entity.Role;
import com.example.shiro1.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Role)表控制层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Role selectOne(int id) {
        return this.roleService.queryById(id);
    }

}