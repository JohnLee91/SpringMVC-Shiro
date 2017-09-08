package org.seckill.rabbitmq.receiver;

import org.springframework.stereotype.Service;
import java.util.concurrent.CountDownLatch;

/**
 * Created by John Lee on 2017/9/8.
 */
@Service
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("receiver msg=" + message.toString());
        latch.countDown();
    }
}



