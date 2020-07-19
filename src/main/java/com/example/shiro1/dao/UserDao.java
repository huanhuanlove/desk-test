package com.example.shiro1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro1.entity.User;
import com.example.shiro1.vo.UserAllMenuVO;
import com.example.shiro1.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

    List<UserAllMenuVO> listAllMenu(@Param("username") String username, @Param("mobile") String mobile);

    User getUserByName(String userName);

    List<User> listUser();

    void saveUser(UserVO userVO);

    void updateUser(UserVO userVO);

    void removeUser(int id);
}