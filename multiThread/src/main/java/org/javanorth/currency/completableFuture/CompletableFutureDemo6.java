package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureDemo6 {

    public static Map<String, List<Integer>> testMap = new ConcurrentHashMap<>();

    static {
        testMap.put("A", Arrays.asList(1,2,3,4,5));
        testMap.put("B", Arrays.asList(6,7,8,9,10));
        testMap.put("C", Arrays.asList(11,12,13,14,15));
        testMap.put("D", Arrays.asList(21,22,23,24,25));
        testMap.put("E", Arrays.asList(31,32,33,34,35));

    }

    public static void main(String[] args) {
        System.out.println(" CompletableFutureDemo5 main start : " + LocalDateTime.now());
        List<String> strings = Arrays.asList("A", "B", "C", "D", "E");


        System.out.println(" availableProcessors: " + Runtime.getRuntime().availableProcessors());
        System.out.println(" maxMemory: " + Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(" freeMemory: " + Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(" totalMemory: " + Runtime.getRuntime().totalMemory()/1024/1024);




        ExecutorService testPool = new ForkJoinPool(10);
//        ExecutorService testPool1 = customerThreadPoolExcuter();
        List<CompletableFuture<Void>> collect = strings.stream().map(
                key -> CompletableFuture.runAsync(() -> {
                    obtainTheList(key);
                }, testPool)
        ).collect(Collectors.toList());
        System.out.println(" CompletableFutureDemo6 supplyAsync end : " + LocalDateTime.now());
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" CompletableFutureDemo6 main end : " + LocalDateTime.now());


    }

//    private static ExecutorService customerThreadPoolExcuter() {
//        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
//        int corePoolSize = 5;
//        int maximumPoolSize = 50;
//        long keepAliveTime = 30l;
//        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit.SECONDS,queue);
//
//    }

    private static void obtainTheList(String key) {
        List<Integer> integers = testMap.get(key);
        try {
            Thread.sleep(2*1000);
            System.out.println(" obtainTheList thread name : " + Thread.currentThread().getName() +" : "+ LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" CompletableFutureDemo6 : " + LocalDateTime.now() +" : " + (integers==null? new ArrayList() :integers));

    }
}
