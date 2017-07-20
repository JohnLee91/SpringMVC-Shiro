package org.seckill.service;

import org.seckill.entity.Organization;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface OrganizationService {


    public Integer createOrganization(Organization organization);
    public Integer updateOrganization(Organization organization);
    public Organization deleteOrganization(Long organizationId);

    Organization selectById(Long organizationId);
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
