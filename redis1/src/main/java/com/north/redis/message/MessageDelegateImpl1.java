package com.north.redis.message;

public class MessageDelegateImpl1 implements MessageDelegate{
    @Override
    public void handleMessage(String message) {
        System.out.println("MessageDelegateImpl1 handleMessage: " + message);
    }
}
