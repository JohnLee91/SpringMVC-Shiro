package org.seckill.controller;

import org.seckill.rabbitmq.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by John Lee on 2017/9/8.
 */
@Controller
@RequestMapping("/rabbitmq/")
public class RabbitMQTestController {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMQTestController.class);
    @Resource
    private Producer producer;

    @RequestMapping("/test/{msg}")
    @ResponseBody
    public String send(@PathVariable("msg") String msg){
        logger.info("#TestController.send#abc={msg}", msg);
        System.out.println("msg="+msg);
        producer.sendDataToQueue("test_queue_key",msg);
        return msg;
    }
}
