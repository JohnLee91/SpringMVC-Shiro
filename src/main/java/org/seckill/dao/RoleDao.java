package org.seckill.dao;

import org.seckill.entity.Role;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface RoleDao {

    public int createRole(Role role);
    public int updateRole(Role role);
    public int deleteRole(Long roleId);

    public Role selectById(Long roleId);
    public List<Role> findAll();
}
