package org.seckill.service.impl;

import org.seckill.aspect.SysLogAnnotation;
import org.seckill.dao.UserDao;
import org.seckill.entity.User;
import org.seckill.realm.UserRealm;
import org.seckill.service.RoleService;
import org.seckill.service.UserService;
import org.seckill.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRealm userRealm;

    /**
     * 创建用户
     * @param user
     */
    @SysLogAnnotation(moduleName="用户管理",option="创建用户")
    @Override
    public Integer createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @SysLogAnnotation(moduleName="用户管理",option="更新用户")
    @Override
    public Integer updateUser(User user) {
        userRealm.clearAllCache();
        return userDao.updateUser(user);
    }

    @SysLogAnnotation(moduleName="用户管理",option="删除用户")
    @Override
    public User deleteUser(Long userId) {
        userRealm.clearAllCache();
        User user = this.selectById(userId);
        user.setAvailable(0);
        this.updateUser(user);

        return user;
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    @SysLogAnnotation(moduleName="用户管理",option="修改密码")
    @Override
    public User changePassword(Long userId, String newPassword) {
        User user =userDao.selectById(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);

        return user;
    }

    @Override
    public User selectById(Long userId) {
        return userDao.selectById(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }

}
