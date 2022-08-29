package com.javanorth.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> testRoutes() {
        return RouterFunctions.route().GET("/flux/function",
                request -> ServerResponse.ok().bodyValue("Hello web flux , Hello Java North")).build();
    }

    @Bean
    public RouterFunction<ServerResponse> testRoutes1() {
        return RouterFunctions.route().GET("/flux/function1", new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                return ServerResponse.ok().bodyValue("hello web flux , Hello Java North");
            }
        }).build();
    }
}
