package com.example.shiro1.vo;

import lombok.Data;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-19-7:10
 * @Description: 描述
 */
@Data
public class UserVO {

    private int id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
}
