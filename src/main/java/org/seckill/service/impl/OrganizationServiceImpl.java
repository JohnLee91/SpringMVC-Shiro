package org.seckill.service.impl;

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

    @Override
    public int createOrganization(Organization organization) {
        return organizationDao.createOrganization(organization);
    }

    @Override
    public int updateOrganization(Organization organization) {
        return organizationDao.updateOrganization(organization);
    }

    @Override
    public int deleteOrganization(Long organizationId) {
        Organization organization = this.selectById(organizationId);
        organization.setAvailable(0);

        return this.updateOrganization(organization);
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
