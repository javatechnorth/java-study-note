package com.javanorth.reactive.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/hello/mono1")
    public Mono<String> mono(){
        return Mono.just("Hello Mono -  Java North");
    }

    @GetMapping("/hello/flux1")
    public Flux<String> flux(){
        return Flux.just("Hello Flux","Hello Java North");
    }

    @GetMapping("/hello/mono")
    public Mono<String> stringMono(){
        Mono<String> from = Mono.fromSupplier(() -> {
            mySleep(5);
            return "Hello, Spring Reactive  date time:"+ LocalDateTime.now();
        });
        System.out.println( "thread : " + Thread.currentThread().getName()+ " ===  " + LocalDateTime.now() +"  ==========Mono function complete==========");
        return from;
    }

    private void mySleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/hello/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux1(){
        Flux<String> stringFlux = Flux.fromStream(IntStream.range(1,6).mapToObj(i ->{
            mySleep(1);
            return "java north flux" + i + "date time: " +LocalDateTime.now();
        }));
        System.out.println("thread : " + Thread.currentThread().getName()+ " ===  " + LocalDateTime.now() + "  ==========Flux function complete=========");
        return stringFlux;
    }
}
