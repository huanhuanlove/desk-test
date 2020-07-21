package com.example.shiro1.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-20-18:46
 * @Description: 描述
 */
@Data
public class UserDTO {

    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 对应的角色
     */
    private List<RoleDTO> roles;
}
