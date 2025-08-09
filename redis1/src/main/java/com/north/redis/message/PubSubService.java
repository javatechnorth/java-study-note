package com.north.redis.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PubSubService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 订阅消息
//    public void subscribe(String channel, MessageListener listener) {
//        redisTemplate.convertAndSend("__keyevent@0__:subscribe", channel);
//        redisTemplate.convertAndSend("__keyevent@0__:psubscribe", channel);
//        listener.setChannel(channel);
//    }

    // 发布消息
    public void publish(String channel, Object message) {
        redisTemplate.opsForValue().set(channel,message);
        redisTemplate.convertAndSend(channel, message);
    }
}
