package com.example.shiro1.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = 880219289185586645L;
    
    private int id;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 父菜单id
    */
    private int pid;
    /**
    * 菜单排序
    */
    private int zindex;
    /**
    * 权限分类（0 菜单；1 功能）
    */
    private int istype;
    /**
    * 描述
    */
    private String descpt;
    /**
    * 菜单编号
    */
    private String code;
    /**
    * 菜单图标名称
    */
    private String icon;
    /**
    * 菜单url
    */
    private String page;
    /**
    * 添加时间
    */
    private Date insertTime;
    /**
    * 更新时间
    */
    private Date updateTime;


}