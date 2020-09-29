/*package com.gujiangbo.application.rabbitmq.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*//**
 * @author gujiangbo
 *//*
@Configuration
public class DirectRabbitConfig {

    public static final String ROUTING_KEY = "springBoot.routingkey.direct";

    public static final String QUEUE_NAME = "directQueue";

    *//**
     * 创建Queue对象
     * durable 是否持久化
     *
     * @return
     *//*
    @Bean
    public static Queue directQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    *//**
     * 创建Direct 交换机
     *
     * @return
     *//*
    @Bean
    public static DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public static Binding bindingDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(ROUTING_KEY);
    }


}
*/