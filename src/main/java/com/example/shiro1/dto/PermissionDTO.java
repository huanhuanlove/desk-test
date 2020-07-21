package com.example.shiro1.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-20-18:47
 * @Description: 描述
 */
@Data
public class PermissionDTO {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单url
     */
    private String page;

    /**
     * 对应的角色
     */
    private List<RoleDTO> roles;
}
