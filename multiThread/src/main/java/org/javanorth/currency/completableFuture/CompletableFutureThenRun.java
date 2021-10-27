package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class CompletableFutureThenRun {

    public static void main(String[] args) {
        System.out.println(" CompletableFutureThenRun main start : " + LocalDateTime.now());
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(" CompletableFutureThenRun  cf1: " + LocalDateTime.now());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "supplyAsync";
        });

        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            System.out.println(" CompletableFutureThenRun  cf2: " + LocalDateTime.now());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        cf1.runAfterBoth(cf2,()-> {
            System.out.println(Thread.currentThread().getName()+" CompletableFutureThenRun runAfterBoth: " + LocalDateTime.now());
        });
        cf1.runAfterBothAsync(cf2,()-> {
            System.out.println( Thread.currentThread().getName()+" CompletableFutureThenRun runAfterBothAsync: " + LocalDateTime.now());
        });
        cf1.runAfterEither(cf2,()-> {
            System.out.println( Thread.currentThread().getName()+" CompletableFutureThenRun runAfterEither: " + LocalDateTime.now());
        });
        cf1.runAfterEitherAsync(cf2,()-> {
            System.out.println( Thread.currentThread().getName()+" CompletableFutureThenRun runAfterEitherAsync: " + LocalDateTime.now());
        });
        cf1.thenRunAsync(()-> {
            System.out.println(Thread.currentThread().getName()+" CompletableFutureThenRun thenRunAsync: " + LocalDateTime.now());
        });
        cf1.thenRun(()-> {
            System.out.println(Thread.currentThread().getName()+" CompletableFutureThenRun thenRun: " + LocalDateTime.now());
        });
        System.out.println(Thread.currentThread().getName() + " CompletableFutureThenRun  last: " + LocalDateTime.now());

        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
