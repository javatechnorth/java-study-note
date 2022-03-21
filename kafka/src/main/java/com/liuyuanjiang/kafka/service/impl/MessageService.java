package com.liuyuanjiang.kafka.service.impl;

import com.liuyuanjiang.kafka.source.KafkaSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Autowired
    private KafkaSource source;

    public Object sendMessage(Object msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
        return msg;
    }


}
