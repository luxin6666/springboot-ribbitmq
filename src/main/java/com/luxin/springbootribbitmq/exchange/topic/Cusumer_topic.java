package com.luxin.springbootribbitmq.exchange.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue("myQueue-topic"),
        exchange = @Exchange(value="exchange-provider-topic",type = ExchangeTypes.TOPIC),
        key = "*.routingkey"))
public class Cusumer_topic {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("接收到的参数："+msg);
    }

}
