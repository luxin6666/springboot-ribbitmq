package com.luxin.springbootribbitmq.exchange.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Provider_direct {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*参数1 交换机名称
      参数2 路由值
      参数3 发送消息*/
    public void send(String msg){
        this.rabbitTemplate.convertAndSend("exchange-provider","routingkey-provider",msg);
    }

}
