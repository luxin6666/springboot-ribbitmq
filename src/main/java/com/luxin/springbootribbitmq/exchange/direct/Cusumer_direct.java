package com.luxin.springbootribbitmq.exchange.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue("myQueue-direct"),
        exchange = @Exchange(value="exchange-provider",type = ExchangeTypes.DIRECT),
        key = "routingkey-provider"))
public class Cusumer_direct {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("接收到的参数："+msg);
    }

}
