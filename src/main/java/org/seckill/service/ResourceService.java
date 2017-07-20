package org.seckill.service;

import org.seckill.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ResourceService {


    public Integer createResource(Resource resource);
    public Integer updateResource(Resource resource);
    public Resource deleteResource(Long resourceId);

    Resource selectById(Long resourceId);
    List<Resource> findAll();

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);
}
