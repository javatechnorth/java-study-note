package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class SseEmitterController {
    private static Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();
    @CrossOrigin(origins = "*")
    @GetMapping("/events")
    public SseEmitter stream() {
        final SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        executor.execute(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000); // 模拟耗时操作
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", i);
                    map.put("content", "SseEmitter : " + i);
                    emitter.send(SseEmitter.event().data(map));
                }
//                emitter.complete();
            } catch (IOException | InterruptedException e) {
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/events/{userId}")
    public SseEmitter stream(@PathVariable String userId) throws IOException {
        sseCache.put(userId,new SseEmitter(10 * 60 * 1000L));
        SseEmitter emitter = sseCache.get(userId);
        Map<String,String> map = new HashMap<>();
        map.put("id", userId);
        map.put("content", "连接成功");
//        emitter.send(SseEmitter.event().reconnectTime(5* 60 * 1000L).data(map));
        emitter.send(map);
        return emitter;
    }

    @GetMapping("/sendMessage/{userId}")
    public String sendMessage(@PathVariable String userId,
                              @RequestParam(name = "message", required = false) String message) throws IOException {
        SseEmitter emitter = sseCache.get(userId);
        Map<String,String> map = new HashMap<>();
        map.put("id", userId);
        map.put("content", message);
        emitter.send(map);
        return "成功";
    }

    @GetMapping("/close/{userId}")
    public String close(@PathVariable String userId
                              ) throws IOException {
        SseEmitter emitter = sseCache.get(userId);
        emitter.complete();
        return "成功";
    }
}

