package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class CompletableFutureThenApply {

    public static Map<String, List<Integer>> testMap = new ConcurrentHashMap<>();

    static {
        testMap.put("A", Arrays.asList(1,2,3,4,5));
        testMap.put("B", Arrays.asList(6,7,8,9,10));
        testMap.put("C", Arrays.asList(11,12,13,14,15));
        testMap.put("D", Arrays.asList(21,22,23,24,25));
        testMap.put("E", Arrays.asList(31,32,33,34,35));
    }

    public static void main(String[] args) {
        System.out.println(" CompletableFutureThenRun main start : " + LocalDateTime.now());
        List<String> strings = Arrays.asList("A", "B", "C", "D", "E");

        CompletableFuture<List<String>> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(" CompletableFutureThenRun  cf1: " + LocalDateTime.now());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strings;
        });

        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            System.out.println(" CompletableFutureThenRun  cf2: " + LocalDateTime.now());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        CompletableFuture<String> stringCF = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "B";
        });
        CompletableFuture<String> cfS = new CompletableFuture<String>();

        cf1.thenApply((list) -> {
            list.forEach(str -> System.out.println(Thread.currentThread().getName()+" CompletableFutureThenApply thenApply: " +testMap.get(str)));
            return "thenApplyComplete";
        });

        CompletableFuture<String> stringCompletableFuture = stringCF.applyToEither(cfS, (str) -> {
            System.out.println(Thread.currentThread().getName() + " CompletableFutureThenApply applyToEither: " + str + " - " + testMap.get(str));
            return "applyToEither";
        });


        CompletableFuture<String> completableFutureCompletableFuture = stringCF.thenApply((str) -> {
                return "completes1";
        });

        CompletableFuture<String> stringCompletableFuture1 = stringCF.thenCompose((str) -> {
            return CompletableFuture.supplyAsync(() -> {
                int i = 1/0;
                return "completes1";
            });
        });

        CompletableFuture<String> handle = stringCompletableFuture1.handle((str, NoPointException) -> {
            System.out.println("handle ： " + str);
            if(NoPointException != null ){
                System.out.println("stringCompletableFuture1 have exception :" );
                NoPointException.printStackTrace();
            }
            return "handle complete ";
        });

        System.out.println(Thread.currentThread().getName() + " CompletableFutureThenRun  last: " + LocalDateTime.now());

        cfS.complete("C");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
