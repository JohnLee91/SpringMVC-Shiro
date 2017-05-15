package org.seckill.exception;

/**
 * Created by John Lee on 2017/2/7.
 * 秒杀相关业务异常
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
