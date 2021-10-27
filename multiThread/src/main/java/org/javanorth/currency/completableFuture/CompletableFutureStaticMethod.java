package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureStaticMethod {
    public static void main(String[] args) {

        System.out.println("start second: " + LocalDateTime.now());
//        CompletableFuture<Integer> cf1 = CompletableFuture.completedFuture(2);
//        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
//        cf1.thenApplyAsync(x->square(x))//Function 有输入有输出
//                .thenAcceptAsync(x -> System.out.println(x)) // Consumer 有输入没有输出
//                .thenRunAsync(() -> System.out.println("javaNorth all complete "));// Runnable 仅执行
//
//        System.out.println("javaNorth-cf1 complete " + LocalDateTime.now().getSecond());
//        cf1.complete(2);


        Throwable throwable = new RuntimeException("test");
        CompletableFuture.failedStage(throwable);
        Executor executor = CompletableFuture.delayedExecutor(5l, TimeUnit.SECONDS);
//        CompletableFuture.

        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(()->{
            try {Thread.sleep(4 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            return "supplyAsync1";
        });
        CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {Thread.sleep(2 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            return "supplyAsync2";
        });

        CompletableFuture.anyOf(supplyAsync1,supplyAsync2).thenAccept((str)->{
            System.out.println(LocalDateTime.now() + " anyOf complete : " + str);
        });

        CompletableFuture.allOf(supplyAsync1,supplyAsync2).thenAccept((str)->{
            System.out.println(LocalDateTime.now() + " allOf complete "+ str );
        });


//        CompletableFuture.failedStage();
//        CompletableFuture.failedFuture()


        try {Thread.sleep(10 * 1000);} catch (InterruptedException e) {e.printStackTrace();}

    }

    private static Object square(Integer x) {
        return x * x;
    }
}
