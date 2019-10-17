package com.springboot.rabbitmq.work;

import com.springboot.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by paul.cheng on 2019/10/17
 * 工作模式
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_WORK_HELLO)
public class WorkReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("WorkReceiver1  : " + hello);
    }
}
