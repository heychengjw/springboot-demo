package com.springboot.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by paul.cheng on 2019/10/17
 */
@Configuration
public class RabbitConfig {

    public static final String QUEUE_SIMPLE_HELLO = "queue_simple_hello";

    public static final String QUEUE_WORK_HELLO = "queue_work_hello";

    public static final String QUEUE_FANOUT_A = "queue_fanout_a";
    public static final String QUEUE_FANOUT_B = "queue_fanout_b";
    public static final String QUEUE_FANOUT_C = "queue_fanout_c";
    public static final String EXCHANGE_FANOUT = "exchange_fanout";

    public static final String QUEUE_TOPIC_A = "queue_topic_a";
    public static final String QUEUE_TOPIC_B = "queue_topic_b";
    public static final String EXCHANGE_TOPIC = "exchange_topic";

    public static final String ROUTINGKEY_TOPIC_A = "topic.message";
    public static final String ROUTINGKEY_TOPIC_B = "topic.messages";
    public static final String ROUTINGKEY_TOPIC_C = "topic.#";

    @Bean
    public Queue simpleQueue(){
        return new Queue(QUEUE_SIMPLE_HELLO);
    }

    @Bean
    public Queue workQueue(){
        return new Queue(QUEUE_WORK_HELLO);
    }

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(QUEUE_FANOUT_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(QUEUE_FANOUT_B);
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue(QUEUE_FANOUT_C);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_FANOUT);
    }

    @Bean
    Binding bindingExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue fanoutQueueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }

    @Bean
    public Queue topicQueueA() {
        return new Queue(QUEUE_TOPIC_A);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(QUEUE_TOPIC_B);
    }

    /**
     * 声明一个Topic类型的交换机
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_TOPIC);
    }

    /**
     * 绑定Q到交换机,并且指定routingKey
     */
    @Bean
    Binding bindingExchangeMessage(Queue topicQueueA, TopicExchange exchange) {
        return BindingBuilder.bind(topicQueueA).to(exchange).with(RabbitConfig.ROUTINGKEY_TOPIC_A);
    }

    @Bean
    Binding bindingExchangeMessages(Queue topicQueueB, TopicExchange exchange) {
        return BindingBuilder.bind(topicQueueB).to(exchange).with(RabbitConfig.ROUTINGKEY_TOPIC_C);
    }

}
