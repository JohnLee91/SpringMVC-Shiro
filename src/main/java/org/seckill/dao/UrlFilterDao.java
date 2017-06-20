package org.seckill.dao;

import org.seckill.entity.UrlFilter;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface UrlFilterDao {

    public int createUrlFilter(UrlFilter urlFilter);
    public int updateUrlFilter(UrlFilter urlFilter);
    public int deleteUrlFilter(Long urlFilterId);

    public UrlFilter findOne(Long urlFilterId);
    public List<UrlFilter> findAll();
}
