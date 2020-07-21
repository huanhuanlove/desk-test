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
public class RoleDTO {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编号
     */
    private String code;

    /**
     * 对应的用户
     */
    private List<UserDTO> users;

    /**
     * 对应的权限
     */
    private List<PermissionDTO> permissions;
}
