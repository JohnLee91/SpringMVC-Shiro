package org.seckill.exception;

/**
 * Created by John Lee on 2017/2/7.
 * 秒杀关闭异常（时间到了，库存完了）
 */
public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
