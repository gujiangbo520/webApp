/*package com.gujiangbo.application.rabbitmq.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

*//**
 * @author gujiangbo
 *//*
@Component
@RabbitListener(queues = DirectRabbitConfig.QUEUE_NAME)//监听的队列名称 directQueues
public class DirectReceiver {

    @RabbitHandler
    public void process(Object testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
*/