package com.springboot.rabbitmq.work;

import com.springboot.rabbitmq.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by paul.cheng on 2019/10/17
 * 工作模式
 */
@Component
public class WorkSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void  send(int i){
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello " + i + " "+ dateTime;
//        System.out.println("WorkSender : " + context);
        //简单对列的情况下routingKey即为Q名
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_WORK_HELLO, context);
    }
}
