package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class CompletableFutureThenAccept {

    public static Map<String, List<Integer>> testMap = new ConcurrentHashMap<>();

    static {
        testMap.put("A", Arrays.asList(1,2,3,4,5));
        testMap.put("B", Arrays.asList(6,7,8,9,10));
        testMap.put("C", Arrays.asList(11,12,13,14,15));
        testMap.put("D", Arrays.asList(21,22,23,24,25));
        testMap.put("E", Arrays.asList(31,32,33,34,35));
    }

    public static void main(String[] args) {


        System.out.println(" CompletableFutureThenRun main start Second : " + LocalDateTime.now().getSecond());
        List<String> strings = Arrays.asList("A", "B", "C", "D", "E");
        List<String> strings1 = Arrays.asList("A", "B", "C");


        CompletableFuture<List<String>> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(" CompletableFutureThenRun  cf1 Second: " + LocalDateTime.now().getSecond());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strings;
        });

        CompletableFuture<List<String>> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(" CompletableFutureThenRun  cf2 Second: " + LocalDateTime.now().getSecond());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strings1;

        });

        cf1.thenAccept((list) -> {
            System.out.println(LocalDateTime.now().getSecond() + " cf1 thenAccept : " + list);
        });

        cf1.acceptEither(cf2,(obj)->{
            System.out.println(LocalDateTime.now().getSecond() + " cf1 acceptEither : " + obj);
        });


        cf1.thenAcceptBoth(cf2,(list1,list2) ->{
            System.out.println(LocalDateTime.now().getSecond() +" cf1 thenAcceptBoth list1 : " + list1);
            System.out.println(LocalDateTime.now().getSecond() + " cf1 thenAcceptBoth list2 : " + list2);

        });



        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " CompletableFutureThenRun  last Second: " + LocalDateTime.now().getSecond());





        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
