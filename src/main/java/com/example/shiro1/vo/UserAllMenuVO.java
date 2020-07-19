package com.example.shiro1.vo;

import lombok.Data;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-4:00
 * @Description: 描述
 */
@Data
public class UserAllMenuVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 权限id
     */
    private int id;
    /**
     * 父菜单id
     */
    private int pid;

    /**
     * 菜单图标名称
     */
    private String icon;
    /**
     * 菜单url
     */
    private String page;
}
