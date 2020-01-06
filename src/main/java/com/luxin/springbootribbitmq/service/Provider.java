package com.luxin.springbootribbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Provider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg){
        this.rabbitTemplate.convertAndSend("myQueue",msg);
    }

}
