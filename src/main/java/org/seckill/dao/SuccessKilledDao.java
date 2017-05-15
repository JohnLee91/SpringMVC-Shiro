package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * Created by John Lee on 2017/2/4.
 */
public interface SuccessKilledDao {

    /**
     * 插入秒杀明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据ID查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone") long userPhone);
}
