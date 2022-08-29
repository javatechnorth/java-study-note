package com.javanorth.reactive;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class FluxTest {

    @Test
    public void test() {
        Flux flux = Flux.range(1, 20);
        Subscriber subscribe = new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                System.out.println(Thread.currentThread().getName() + " -> " + value);
//                request(1);
            }
        };

        flux.subscribe(subscribe);
    }


    @Test
    public void monoTest() {
        Mono mono = Mono.just(10);
        Subscriber subscribe = new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                System.out.println(Thread.currentThread().getName() + " -> " + value);
                request(value);
            }
        };
//        mono.
        mono.subscribe(subscribe);
    }


    @Test
    public void fluxTestPull1() {
        Flux.generate(sink -> {
            int k = (int) (Math.random() * 10);
            if (k > 7) {
                sink.complete();
            }
            sink.next(k);

        }).subscribe(i -> {
            System.out.println(" Flux Pull " + i);
        });
    }


    //    @Test
    public static void main(String[] args) {
        Flux.create(sink -> {
            System.out.println("enter data:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                try {
                    sink.next(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribe(i -> {
            System.out.println(Thread.currentThread().getName() + " flux push" + i);
        });


    }

    @Test
    public void fluxSchedulers1() {
        Flux.range(1, 4).doOnNext(i -> {
                    System.out.println(Thread.currentThread().getName() + " doONnEXT " + i);
                }).publishOn(Schedulers.newParallel("north parallel"))
                .skip(2)
                .subscribe(i -> {
                    System.out.println(Thread.currentThread().getName() + " receive " + i);
                });
    }

    @Test
    public void fluxSchedulers2() {
        Flux.range(1, 4).doOnNext(i -> {
                    System.out.println(Thread.currentThread().getName() + " doONnEXT " + i);
                })
                .subscribeOn(Schedulers.newParallel("north parallel"))
                .skip(2)
                .subscribe(i -> {
                    System.out.println(Thread.currentThread().getName() + " receive " + i);
                });
    }

    @Test
    public void fluxGenerateTest() {
        Flux.generate(() -> 0, (i, sink) -> {
            sink.next("2*" + i + "=" + 2 * i);
            if (i > 9) sink.complete();
            return i + 1;
        }).subscribe(System.out::println);
    }

    @Test
    public void monoFluxGenerateTEST(){
        Mono.empty().subscribe(System.out::println);
        Mono.just("Hello Mono Java North").subscribe(System.out::print);

        Flux.just(1,2,3,4,5).subscribe(System.out::print);
        Flux.range(1,20).subscribe(System.out::print);
        Flux.fromArray(new String[]{"a1","a2","a3","a4","a5","a6"}).skip(2).subscribe(System.out::print);
        Flux.fromIterable(Arrays.asList(1,2,3,4,5,6,7)).subscribe(System.out::println);
        Flux.fromStream(Stream.of(Arrays.asList(1,2,3,4,5,6,7))).subscribe(System.out::print);
        Flux.generate(() -> 0, (i, sink) -> {
            sink.next("3*" + i + "=" + 3 * i);
            if (i > 9) sink.complete();
            return i + 1;
        }).subscribe(System.out::println);



        String str = "qa ws ed rf tg yh uj i k ol p za sx dc vf bg hn jm k loi yt ";
        Flux.fromArray(str.split(" "))
                .flatMap(i -> Flux.fromArray(i.split("")))
                .distinct()
                .sort()
                .subscribe(System.out::print);
    }

}
