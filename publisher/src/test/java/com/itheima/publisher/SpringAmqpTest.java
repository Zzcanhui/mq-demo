package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    void testsimpleQueue() {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, spring amqp!";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    void testWorkQueue() {
        // 队列名称
        String queueName = "work.queue";
        for (int i = 0; i < 50; i++) {
            // 消息
            String message = "hello, spring amqp!" + i;
            // 发送消息
            rabbitTemplate.convertAndSend(queueName, message);


        }
    }

    @Test
    void testFanoutQueue() {
        // 交换机名称
        String exchangeName = "hmall.fanout";
        // 消息
        String message = "hello, fanout queue!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }


}