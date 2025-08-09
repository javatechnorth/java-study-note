package com.liuyuanjiang.redis.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber implements MessageListener {


    public void onMessage(String message, byte[] bytes) {
        // 处理接收到的消息
        System.out.println("Received message: " + message);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Received message: " + message);
        // 接收的topic
        System.out.println("channel:" + new String(pattern));
        // 消息的POJO
        System.out.println("message:" + message.toString());
    }
}