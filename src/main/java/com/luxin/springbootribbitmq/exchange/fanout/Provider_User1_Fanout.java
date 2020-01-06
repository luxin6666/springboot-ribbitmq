package com.luxin.springbootribbitmq.exchange.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Provider_User1_Fanout {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg){
        this.rabbitTemplate.convertAndSend("exchange-provider-fanout",null, msg);
    }

}
