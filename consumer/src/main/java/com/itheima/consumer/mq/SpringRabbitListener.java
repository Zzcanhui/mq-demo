package com.itheima.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Slf4j
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg) {
        log.info("监听到simple.queue的消息: {}", msg);
    }


    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) {
        System.out.println("消费者1收到消息: " + msg + "," + LocalTime.now());
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) {
        System.err.println("消费者2........收到消息: " + msg + "," + LocalTime.now());
    }
}
