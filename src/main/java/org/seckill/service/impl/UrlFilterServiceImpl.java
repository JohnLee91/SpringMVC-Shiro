package org.seckill.service.impl;

import org.seckill.aspect.SysLogAnnotation;
import org.seckill.dao.UrlFilterDao;
import org.seckill.entity.UrlFilter;
import org.seckill.realm.UserRealm;
import org.seckill.service.UrlFilterService;
import org.seckill.util.ShiroFilerChainManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-25
 * <p>Version: 1.0
 */
@Service
public class UrlFilterServiceImpl implements UrlFilterService {

    @Autowired
    private UrlFilterDao urlFilterDao;

    @Autowired
    private ShiroFilerChainManager shiroFilerChainManager;

    @Autowired
    private UserRealm userRealm;

    @SysLogAnnotation(moduleName="URL过滤管理",option="创建URL过滤")
    @Override
    public Integer createUrlFilter(UrlFilter urlFilter) {
        int result = urlFilterDao.createUrlFilter(urlFilter);
        initFilterChain();
        return result;
    }

    @SysLogAnnotation(moduleName="URL过滤管理",option="更新URL过滤")
    @Override
    public Integer updateUrlFilter(UrlFilter urlFilter) {
        int result = urlFilterDao.updateUrlFilter(urlFilter);
        userRealm.clearAllCache();
        initFilterChain();
        return result;
    }

    @SysLogAnnotation(moduleName="URL过滤管理",option="删除URL过滤")
    @Override
    public UrlFilter deleteUrlFilter(Long urlFilterId) {
        UrlFilter urlFilter = this.selectById(urlFilterId);
        urlFilter.setAvailable(0);
        this.updateUrlFilter(urlFilter);
        initFilterChain();

        return urlFilter;
    }

    @Override
    public UrlFilter selectById(Long urlFilterId) {
        return urlFilterDao.selectById(urlFilterId);
    }

    @Override
    public List<UrlFilter> findAll() {
        return urlFilterDao.findAll();
    }

    @PostConstruct
    public void initFilterChain() {
        shiroFilerChainManager.initFilterChains(findAll());
    }

}
