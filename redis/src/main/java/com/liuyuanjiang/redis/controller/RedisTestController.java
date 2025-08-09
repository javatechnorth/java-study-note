package com.liuyuanjiang.redis.controller;

import com.liuyuanjiang.redis.message.MessagePublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/redis")
public class RedisTestController {

    @Resource
    private MessagePublisher messagePublisher;

    @RequestMapping("/test1")
     public ResponseEntity<String> test1(){
        messagePublisher.publishMessage("test123");
        return new ResponseEntity<>(HttpStatus.OK);
     }
}
