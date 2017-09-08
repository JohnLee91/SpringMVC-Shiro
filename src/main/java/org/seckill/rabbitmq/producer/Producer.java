package org.seckill.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by John Lee on 2017/9/8.
 */
@Service
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final static Logger logger = LoggerFactory.getLogger(Producer.class);

    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exeception={}",e);
        }
    }
}