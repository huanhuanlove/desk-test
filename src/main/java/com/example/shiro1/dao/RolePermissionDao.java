package com.example.shiro1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro1.entity.RolePermission;
import com.example.shiro1.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (RolePermission)表数据库访问层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@Mapper
public interface RolePermissionDao extends BaseMapper<RolePermission> {

    /**
     * 通过ID查询单条数据
     *
     * @param permitId 主键
     * @return 实例对象
     */
    RolePermission queryById(int permitId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RolePermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolePermission 实例对象
     * @return 对象列表
     */
    List<RolePermission> queryAll(RolePermission rolePermission);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 影响行数
     */
    int insert(RolePermission rolePermission);

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return 影响行数
     */
    int update(RolePermission rolePermission);

    /**
     * 通过主键删除数据
     *
     * @param permitId 主键
     * @return 影响行数
     */
    int deleteById(int permitId);

}