package org.seckill.service;

import org.seckill.entity.UrlFilter;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface UrlFilterService {

    public Integer createUrlFilter(UrlFilter urlFilter);
    public Integer updateUrlFilter(UrlFilter urlFilter);
    public UrlFilter deleteUrlFilter(Long urlFilterId);

    public UrlFilter selectById(Long urlFilterId);
    public List<UrlFilter> findAll();
}
