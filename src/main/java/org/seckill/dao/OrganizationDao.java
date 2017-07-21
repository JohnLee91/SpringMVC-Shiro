package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Organization;

import java.util.List;

/**
 * <p>Organization: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface OrganizationDao {

    public int createOrganization(Organization organization);
    public int updateOrganization(Organization organization);
    public int deleteOrganization(Long organizationId);

    Organization selectById(Long organizationId);
    List<Organization> findAll();

    List<Organization> findAllWithExclude(Organization excludeOraganization);

    void moveFirst(@Param("source") Organization source, @Param("target") Organization target);
    void moveSecond(@Param("source") Organization source, @Param("target") Organization target);
}
