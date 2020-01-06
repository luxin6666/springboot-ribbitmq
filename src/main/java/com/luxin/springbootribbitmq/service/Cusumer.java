package com.luxin.springbootribbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Cusumer {

    @RabbitListener(queues = "myQueue")
    private void receive(String msg){
        System.out.println("接收到的参数为："+msg);
    }

}
