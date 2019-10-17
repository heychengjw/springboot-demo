package com.springboot.rabbitmq.fanout;

import com.springboot.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by paul.cheng on 2019/10/17
 * 订阅模式
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_FANOUT_B)
public class FanoutReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("FanoutReceiver2  : " + hello);
    }
}
