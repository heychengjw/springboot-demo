package com.springboot.rabbitmq.topic;

import com.springboot.rabbitmq.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by paul.cheng on 2019/10/17
 * 主题模式
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        String context = "hi, i am message 1";
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, RabbitConfig.ROUTINGKEY_TOPIC_A, context);
    }


    public void send2() {
        String context = "hi, i am messages 2";
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, RabbitConfig.ROUTINGKEY_TOPIC_B, context);
    }
}
