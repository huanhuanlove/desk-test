package com.example.shiro1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro1.dto.PermissionDTO;
import com.example.shiro1.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Permission)表数据库访问层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@Mapper
public interface PermissionDao extends BaseMapper<Permission> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Permission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param permission 实例对象
     * @return 对象列表
     */
    List<Permission> queryAll(Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

    /***********************************************************************************************************/
    /****************************************          shiro功能练习        ************************************/
    /***********************************************************************************************************/
    List<PermissionDTO> listPermissionByRoleName(String roleName);

}