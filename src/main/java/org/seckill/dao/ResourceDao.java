package org.seckill.dao;

import org.seckill.entity.Resource;

import java.util.List;

/**
 * <p>Resource: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ResourceDao {

    public int createResource(Resource resource);
    public int updateResource(Resource resource);
    public int deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();

}
