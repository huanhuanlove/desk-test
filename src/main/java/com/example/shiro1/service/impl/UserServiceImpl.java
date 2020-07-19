package com.example.shiro1.service.impl;

import com.example.shiro1.entity.User;
import com.example.shiro1.dao.UserDao;
import com.example.shiro1.service.UserService;
import com.example.shiro1.vo.UserAllMenuVO;
import com.example.shiro1.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(int id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public List<UserAllMenuVO> listAllMenu(String username, String mobile) {
        return userDao.listAllMenu(username, mobile);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public void saveUser(UserVO userVO) {
        userDao.saveUser(userVO);
    }

    @Override
    public void updateUser(UserVO userVO) {
        userDao.updateUser(userVO);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
}