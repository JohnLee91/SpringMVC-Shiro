package org.seckill.service.impl;

import org.seckill.aspect.SysLogAnnotation;
import org.seckill.dao.ResourceDao;
import org.seckill.entity.Resource;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.seckill.realm.UserRealm;
import org.seckill.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private UserRealm userRealm;

    @SysLogAnnotation(moduleName="资源管理",option="创建资源")
    @Override
    public int createResource(Resource resource) {
        return resourceDao.createResource(resource);
    }

    @SysLogAnnotation(moduleName="资源管理",option="更新资源")
    @Override
    public int updateResource(Resource resource) {
        userRealm.clearAllCache();
        return resourceDao.updateResource(resource);
    }

    @SysLogAnnotation(moduleName="资源管理",option="删除资源")
    @Override
    public Resource deleteResource(Long resourceId) {
        userRealm.clearAllCache();
        Resource resource = this.selectById(resourceId);
        resource.setAvailable(0);
        this.updateResource(resource);

        return resource;
    }

    @Override
    public Resource selectById(Long resourceId) {
        return resourceDao.selectById(resourceId);
    }

    @Override
    @SysLogAnnotation(moduleName="资源管理",option="查询资源")
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            Resource resource = selectById(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        List<Resource> allResources = findAll();
        List<Resource> menus = new ArrayList<Resource>();
        for(Resource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            if(resource.getType() != Resource.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
