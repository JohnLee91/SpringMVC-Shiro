package org.seckill.service.impl;

import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDaoTest;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;


/**
 * Created by John Lee on 2017/2/21.
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-aspect,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
    private static Logger log = LoggerFactory.getLogger(SeckillDaoTest.class);

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        log.info("list={}", list);

    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        log.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        log.info("exposer={}", exposer);
        //Exposer{exposed=true, md5='08f69661aceacec0fcab4a7049454d70', seckillId=1000, now=0, start=0, end=0}

    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000;
        long phone = 15555555555L;
        String md5 = "08f69661aceacec0fcab4a7049454d70";
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
            log.info("result={}", seckillExecution);
        } catch (RepeatKillException e) {
            log.error(e.getMessage());
        } catch (SeckillCloseException e) {
            log.error(e.getMessage());
        }
    }

    //集成测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            log.info("exposer={}", exposer);

            long phone = 15555555555L;
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, exposer.getMd5());
                log.info("result={}", seckillExecution);
            } catch (RepeatKillException e) {
                log.error(e.getMessage());
            } catch (SeckillCloseException e) {
                log.error(e.getMessage());
            }
        } else {
            //秒杀未开启
            log.warn("exposer={}", exposer);
        }
    }

    @Test
    public void testSeckill() throws Exception {
        long id = 1002;
        Seckill seckill = seckillService.getById(id);
        log.info("seckill={}", seckill);
    }

    @Test
    public void testSeckillProcedure() throws Exception {
        long seckillId = 1001;
        long phone = 13555555555L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, exposer.getMd5());
            log.info(execution.getStateInfo());
        }
    }

    @Test
    public void testRedisQPS()throws Exception {
        //redis操作逻辑
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + 1001;
                //并没有实现内部序列号操作
                // get->byte[]->反序列化->Object(Seckill)
                //java序列化比较：https://github.com/eishay/jvm-serializers/wiki
                //采用自定义序列化，不用jdk的序列化
                //protostuff：必须是pojo对象
                long start = System.currentTimeMillis();
                int count = 0;

                while (System.currentTimeMillis()-start <= 1000){
                    byte[] bytes = jedis.get(key.getBytes());
                    if (bytes != null) {//缓存获取到
                        Seckill seckill = schema.newMessage();
                        ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                        //seckill被反序列化
                        //log.info("seckill:"+seckill);
                    }
                    count++;
                }
                log.info("count:"+count);
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void testSqlQPS()throws Exception {
        try {
            long id = 1001;
            long start = System.currentTimeMillis();
            int count = 0;

            while (System.currentTimeMillis()-start <= 1000){
                Seckill seckill = seckillService.getById(id);
                count++;
            }
            log.info("count:"+count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}