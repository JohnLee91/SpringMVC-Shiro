package org.seckill.service.impl;

import org.seckill.dao.SysLogDao;
import org.seckill.entity.SysLog;
import org.seckill.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: JohnLee
 * <p>Date: 2017-7-4 10:16:46
 * <p>Version: 1.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public int insertLog(SysLog sysLog) {
        return sysLogDao.insert(sysLog);
    }

    @Override
    public int updateLog(SysLog sysLog) {
        return sysLogDao.update(sysLog);
    }

    @Override
    public int deleteLog(Long logId) {
        return sysLogDao.delete(logId);
    }

    @Override
    public SysLog selectById(Long logId) {
        return sysLogDao.selectById(logId);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
