package org.seckill.service;

import org.seckill.entity.SysLog;

import java.util.List;

/**
 * <p>User: JohnLee
 * <p>Date: 2017-7-4 10:16:46
 * <p>Version: 1.0
 */
public interface SysLogService {
    public int insertLog(SysLog sysLog);
    public int updateLog(SysLog sysLog);
    public int deleteLog(Long logId);

    SysLog selectById(Long logId);
    List<SysLog> findAll();
}
