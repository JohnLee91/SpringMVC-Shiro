package org.seckill.dao;

import org.seckill.entity.User;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface UserDao {

    public int createUser(User user);
    public int updateUser(User user);
    public int deleteUser(Long userId);

    User selectById(Long userId);

    List<User> findAll();

    User findByUsername(String username);

}
