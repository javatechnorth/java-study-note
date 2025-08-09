package com.north.redis.message;

public interface MessagePublisher {
    void publish(String message);
}