package com.liuyuanjiang.kafka.source;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(KafkaSource.class)
public class SourceProducer {


    @SendTo(KafkaSource.OUTPUT)
    public Object sendMessage(Object msg) {
        return msg;
    }

}
