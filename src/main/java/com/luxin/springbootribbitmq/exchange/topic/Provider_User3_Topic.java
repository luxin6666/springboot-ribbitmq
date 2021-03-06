package com.luxin.springbootribbitmq.exchange.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Provider_User3_Topic {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg){
        this.rabbitTemplate.convertAndSend("exchange-provider-topic","user3.poutingkey",msg);
    }


}
