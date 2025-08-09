package com.north.redis.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service("redisMessageSubscriber")
public class RedisMessageSubscriber implements MessageListener {

    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message received: " + message.toString());
    }

}