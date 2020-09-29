/*package com.gujiangbo.application.rabbitmq;

import com.gujiangbo.application.rabbitmq.utils.DirectRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

*//**
 * RabbitMQ 测试类 生产者
 *
 * @author gujiangbo
 *//*
@RestController
public class SendMessageController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendDirectMessage")
    public String sendDirectMessage(@RequestBody String requestBody, HttpServletRequest httpServletRequest) {
        rabbitTemplate.convertAndSend("directExchange", DirectRabbitConfig.ROUTING_KEY, requestBody);

        return "send success !";
    }
}
*/