package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by John Lee on 2017/2/6.
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    private static Logger log = LoggerFactory.getLogger(SeckillDaoTest.class);

    //注入Dao实现类依赖
    @Resource
    private  SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        log.info(seckill.toString());
    }

    @Test
    public void queryAll() throws Exception {
        //Parameter 'offset' not found. Available parameters are [1, 0, param1, param2]
        //java没有保存形参的记录：queryAll(int offset,int limit) -> queryAll(arg0,arg1)

        List<Seckill> list = seckillDao.queryAll(0,100);
        for (Seckill seckill:list) {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        long id = 1000;
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(id,killTime);
        System.out.println("updateCount = " + updateCount);
    }

}