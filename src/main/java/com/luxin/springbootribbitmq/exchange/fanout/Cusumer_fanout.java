package com.luxin.springbootribbitmq.exchange.fanout;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue("myQueue-fanout"),
        exchange = @Exchange(value = "exchange-provider-fanout", type = ExchangeTypes.FANOUT)
))
public class Cusumer_fanout {

    /*@RabbitHandler
    public void receive(String msg){
        System.out.println("接收到的参数为："+msg);
    }*/

    //手动确认消息机制
    @RabbitHandler
    public void receive(String msg, Channel channel, @Headers Map<String,Object> headers){
        try {
            //获取channel的唯一标识
            long delivery_tag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
            //手动确认  当消息正常被消费后  ，可以将此条消息删除了
            channel.basicAck(delivery_tag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接收到的参数为："+msg);
    }

}
