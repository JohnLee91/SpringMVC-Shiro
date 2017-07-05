/*
 * SysLogDao.java
 * Copyright(C) 2016-2020 �Ĵ�ʡ������о�Ժ
 * All rights reserved.
 * -----------------------------------------
 * 2017-07-04 Created.
 */
package org.seckill.dao;

import org.seckill.entity.SysLog;

import java.util.List;

public interface SysLogDao {
    int delete(Long id);

    int insert(SysLog record);

    SysLog selectById(Long id);

    int update(SysLog record);

    List<SysLog> findAll();
}