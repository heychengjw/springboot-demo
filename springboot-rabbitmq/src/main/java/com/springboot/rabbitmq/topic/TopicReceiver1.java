package com.springboot.rabbitmq.topic;

import com.springboot.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by paul.cheng on 2019/10/17
 * 主题模式
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_TOPIC_A)
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("TopicReceiver1  : " + hello);
    }
}
