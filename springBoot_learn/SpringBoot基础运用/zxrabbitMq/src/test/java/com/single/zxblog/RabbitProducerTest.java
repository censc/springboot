package com.single.zxblog;

import com.single.zxblog.mq.RabbitProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitProducerTest {

    @Autowired
    RabbitProducer rabbitProducer;
    
    @Test
    public void sendSimpleMessage(){
        rabbitProducer.send();
    }

}
