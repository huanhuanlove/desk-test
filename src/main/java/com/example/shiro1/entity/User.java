package com.example.shiro1.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -90817308255639459L;
    
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
    /**
    * 添加该用户的用户id
    */
    private int insertUid;
    /**
    * 注册时间
    */
    private Date insertTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 是否删除（0：正常；1：已删）
    */
    private Object isDel;
    /**
    * 是否在职（0：正常；1，离职）
    */
    private Object isJob;
    /**
    * 短信验证码
    */
    private String mcode;
    /**
    * 短信发送时间
    */
    private Date sendTime;
    /**
    * 更新版本
    */
    private int version;


}