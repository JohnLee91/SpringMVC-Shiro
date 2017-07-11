package org.seckill.service;

import com.github.pagehelper.PageInfo;
import org.seckill.entity.SysLog;

import java.util.List;

/**
 * <p>User: JohnLee
 * <p>Date: 2017-7-4 10:16:46
 * <p>Version: 1.0
 */
public interface SysLogService {
    int insertLog(SysLog sysLog);
    int updateLog(SysLog sysLog);
    int deleteLog(Long logId);

    SysLog selectById(Long logId);
    List<SysLog> findAll();
    PageInfo<SysLog> queryByPage(String moduleName, String options, Integer pageNo, Integer pageSize);
}
