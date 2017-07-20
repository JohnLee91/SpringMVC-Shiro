package org.seckill.service.impl;

import org.seckill.aspect.SysLogAnnotation;
import org.seckill.dao.RoleDao;
import org.seckill.entity.Role;
import org.seckill.realm.UserRealm;
import org.seckill.service.ResourceService;
import org.seckill.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserRealm userRealm;

    @SysLogAnnotation(moduleName="角色管理",option="创建角色")
    @Override
    public Integer createRole(Role role) {
        return roleDao.createRole(role);
    }

    @SysLogAnnotation(moduleName="角色管理",option="更新角色")
    @Override
    public Integer updateRole(Role role) {
        userRealm.clearAllCache();
        return roleDao.updateRole(role);
    }

    @SysLogAnnotation(moduleName="角色管理",option="删除角色")
    @Override
    public Role deleteRole(Long roleId) {
        Role role = this.selectById(roleId);
        role.setAvailable(0);
        this.updateRole(role);

        return role;
    }

    @Override
    public Role selectById(Long roleId) {
        return roleDao.selectById(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = selectById(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = selectById(roleId);
            if(role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }
}
