package com.example.shiro1.service;

import com.example.shiro1.entity.User;
import com.example.shiro1.vo.UserAllMenuVO;
import com.example.shiro1.vo.UserVO;

import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

    List<UserAllMenuVO> listAllMenu(String username, String mobile);

    User getUserByName(String userName);

    List<User> listUser();

    void saveUser(UserVO userVO);

    void updateUser(UserVO userVO);

    void removeUser(int id);
}