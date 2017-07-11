package org.seckill.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<SysLog> queryByPage(String moduleName, String options, Integer pageNo, Integer pageSize){

        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<SysLog> list = sysLogDao.queryByPage(moduleName,options);
        //用PageInfo对结果进行包装
        PageInfo<SysLog> page = new PageInfo<SysLog>(list);
        //测试PageInfo全部属性
/*        System.out.println("getPageNum:"+page.getPageNum());
        System.out.println("getPageSize:"+page.getPageSize());
        System.out.println("getStartRow:"+page.getStartRow());
        System.out.println("getEndRow:"+page.getEndRow());
        System.out.println("getTotal:"+page.getTotal());
        System.out.println("getPages:"+page.getPages());
        System.out.println("getFirstPage:"+page.getFirstPage());
        System.out.println("getLastPage:"+page.getLastPage());
        System.out.println("isHasPreviousPage:"+page.isHasPreviousPage());
        System.out.println("isHasNextPage:"+page.isHasNextPage());*/

        return page;
    }
}
