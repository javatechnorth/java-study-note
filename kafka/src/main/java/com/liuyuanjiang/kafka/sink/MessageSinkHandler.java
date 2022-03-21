package com.liuyuanjiang.kafka.sink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class MessageSinkHandler {

    @StreamListener(Sink.INPUT)
    public void handler(Message<String> msg){
        System.out.println(" received message : "+msg);

    }
}
