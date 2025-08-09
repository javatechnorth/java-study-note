package com.north.redis.message;

public interface MessageDelegate {
    void handleMessage(String message);
//    void handleMessage(Map message);
//    void handleMessage(byte[] message);
//    void handleMessage(Serializable message);
//    // pass the channel/pattern as well
//    void handleMessage(Serializable message, String channel);
}
