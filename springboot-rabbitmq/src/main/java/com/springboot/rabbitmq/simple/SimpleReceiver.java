package com.springboot.rabbitmq.simple;

import com.springboot.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by paul.cheng on 2019/10/17
 * 简单队列
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_SIMPLE_HELLO)
public class SimpleReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("SimpleReceiver  : " + hello);
    }
}
