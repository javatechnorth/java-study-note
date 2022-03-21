package com.liuyuanjiang.kafka.controller;

import com.liuyuanjiang.kafka.service.impl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/sendMessage/{msg}")
    public String sendMessage(@PathVariable("msg") String msg){
        messageService.sendMessage("messageService send out : " + msg + LocalDateTime.now());
        return "sent message";
    }
}
