package com.north.redis.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Received message: " + new String(message.getBody()));
    }


//    public void setChannel(String channel) {
//        this.channel = channel;
//    }
}