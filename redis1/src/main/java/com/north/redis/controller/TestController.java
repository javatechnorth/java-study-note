package com.north.redis.controller;

import com.north.redis.message.MessagePublisher;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TestController {
    @Resource
    private MessagePublisher redisMessagePublisher;

    @GetMapping("/hello")
    public Flux<String> hello(@RequestParam String message) {
        redisMessagePublisher.publish(message);
        return Flux.just("Hello", "Webflux");
    }
}