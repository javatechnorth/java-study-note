package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureDemo5 {

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

        ExecutorService testPool = new ForkJoinPool(4);
        List<CompletableFuture<List<Integer>>> collect = strings.stream().map(
                key -> CompletableFuture.supplyAsync(() -> {
                    return obtainTheList(key);
                },testPool).exceptionally((exc)->{
                    System.out.println(" hit  the exception " );
                    throw new RuntimeException(exc);
                })
        ).collect(Collectors.toList());

        System.out.println(" CompletableFutureDemo5 supplyAsync end : " + LocalDateTime.now());
        try {
            List<List<Integer>> integerCollect = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(" catch  the exception " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(" CompletableFutureDemo5 main end : " + LocalDateTime.now());
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    private static List<Integer> obtainTheList(String key) {
        List<Integer> integers = testMap.get(key);
        if( key.equals("C") ){
            throw new RuntimeException("exception test !");
        }
        try {
            Thread.sleep(2*1000);
            System.out.println(" obtainTheList thread name : " + Thread.currentThread().getName() +" : "+ LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return integers==null? new ArrayList() :integers;
    }

//    private static ExecutorService customerThreadPoolExcuter() {
//        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
//        int corePoolSize = 5;
//        int maximumPoolSize = 50;
//        long keepAliveTime = 30l;
//        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit.SECONDS,queue);
//
//    }
}
