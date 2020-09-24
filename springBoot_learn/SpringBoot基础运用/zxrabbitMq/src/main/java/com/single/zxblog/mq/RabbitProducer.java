package com.single.zxblog.mq;

import com.single.zxblog.mq.property.Producer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Component
public class RabbitProducer {
    
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    public void send(){
        String messageContent = "Hi,测试一下RabbitMq,使用一下2" + LocalDate.now().toString();
        
        System.out.println("消息内容:" + messageContent);
    
        // 指定消息类型
        MessageProperties props = MessagePropertiesBuilder.newInstance().setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).build();
        
        // 发送消息
        rabbitTemplate.send(Producer.QUEUE_NAME,new Message(messageContent.getBytes(StandardCharsets.UTF_8),props));
    
        System.out.println("消息发送完毕。");
    }
}
