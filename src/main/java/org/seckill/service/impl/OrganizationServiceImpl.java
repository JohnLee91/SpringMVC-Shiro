package org.seckill.service.impl;

import org.seckill.aspect.SysLogAnnotation;
import org.seckill.dao.OrganizationDao;
import org.seckill.entity.Organization;
import org.seckill.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @SysLogAnnotation(moduleName="组织机构管理",option="创建组织机构")
    @Override
    public Integer createOrganization(Organization organization) {
        return organizationDao.createOrganization(organization);
    }

    @SysLogAnnotation(moduleName="组织机构管理",option="修改组织机构")
    @Override
    public Integer updateOrganization(Organization organization) {
        return organizationDao.updateOrganization(organization);
    }

    @SysLogAnnotation(moduleName="组织机构管理",option="删除组织机构")
    @Override
    public Organization deleteOrganization(Long organizationId) {
        Organization organization = this.selectById(organizationId);
        organization.setAvailable(0);
        this.updateOrganization(organization);

        return organization;
    }

    @Override
    public Organization selectById(Long organizationId) {
        return organizationDao.selectById(organizationId);
    }

    @Override
    public List<Organization> findAll() {
        return organizationDao.findAll();
    }

    @Override
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        return organizationDao.findAllWithExclude(excludeOraganization);
    }

    @Override
    public void move(Organization source, Organization target) {
        organizationDao.move(source, target);
    }
}
