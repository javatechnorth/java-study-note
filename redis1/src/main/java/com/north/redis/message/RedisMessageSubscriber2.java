package com.north.redis.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service("redisMessageSubscriber2")
public class RedisMessageSubscriber2 implements MessageListener {

    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message received2: " + message.toString());
    }

}