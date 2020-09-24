package com.single.zxblog.mq;

import com.rabbitmq.client.Channel;
import com.single.zxblog.mq.property.Producer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitConsumer {

    @RabbitListener(queues = Producer.QUEUE_NAME)
    public void onMessage(Message message, Channel channel) throws IOException {
        System.out.println("Message content : " + message);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消息已确认");
    }
    
}
