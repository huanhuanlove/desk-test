package com.example.shiro1.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 431462256934977250L;
    
    private int id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String descpt;
    /**
    * 角色编号
    */
    private String code;
    /**
    * 操作用户id
    */
    private int insertUid;
    /**
    * 添加数据时间
    */
    private Date insertTime;
    /**
    * 更新时间
    */
    private Date updateTime;


}