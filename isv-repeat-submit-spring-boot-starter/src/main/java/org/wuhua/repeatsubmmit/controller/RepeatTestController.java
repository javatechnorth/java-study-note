package org.wuhua.repeatsubmmit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wuhua.repeatsubmmit.common.RepeatSubmit;
import org.wuhua.repeatsubmmit.entity.User;
import reactor.core.publisher.Mono;

@RestController
public class RepeatTestController {

    @RepeatSubmit
    @GetMapping("/hello/mono1")
    public Mono<String> mono(){
        return Mono.just("Hello Mono -  Java North");
    }

    @RepeatSubmit
    @PostMapping ("/hello/mono1")
    public Mono<String> mono1(@RequestBody User user){
        return Mono.just("Hello Mono -  Java North-"+user.getName());
    }
}
