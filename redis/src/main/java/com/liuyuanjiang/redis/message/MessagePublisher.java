package com.liuyuanjiang.redis.message;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final StringRedisTemplate redisTemplate;

    public MessagePublisher(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publishMessage(String message) {
        redisTemplate.convertAndSend("message-queue", message);
    }

    /**
     * 发布消息到指定的频道
     * @param channel 频道名称
     * @param message 消息内容
     */
    public void publish(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }

    /**
     * 订阅指定频道的消息
     * @param channel 频道名称
     * @param messageHandler 消息处理器
     */
//    public void subscribe(String channel, MessageHandler messageHandler) {
//        redisTemplate.s
//    }
}