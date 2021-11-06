package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;

public class CompletableFutureException {

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

//        cf1.thenCompose((list) -> {
////            list.forEach(str -> System.out.println(Thread.currentThread().getName()+" CompletableFutureThenApply thenApply: " +testMap.get(str)));
////            return "thenApplyComplete";
//
//        });

        CompletableFuture<String> stringCF1 = stringCF.applyToEither(cfS, (str) -> {
            System.out.println(Thread.currentThread().getName() + " CompletableFutureThenApply applyToEither: " + str + " - " + testMap.get(str));
            return "applyToEither";
        });


        CompletableFuture<CompletableFuture<String>> completableFutureCompletableFuture = stringCF.thenApply((str) -> {
            return CompletableFuture.supplyAsync(() -> {
                return "completes1";
            });
        });

        CompletableFuture<String> stringCompletableFuture1 = stringCF.thenCompose((str) -> {
            return CompletableFuture.supplyAsync(() -> {
                throw new RuntimeException(" CompletableFuture throw one exception");
//                return "thenCompose";
            });
        });

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
//            throw new RuntimeException(" CompletableFuture throw one exception");
            return "cc";
        });

//        CompletableFuture<String> exceptionally = stringCompletableFuture.exceptionally((exception) -> {
//            System.out.println("exceptionally only execute  when error throw ");
//            return "exception";
//        });
//         System.out.println("exceptionally  ： " + exceptionally.join());

//        CompletableFuture<String> whenCompleteCF = stringCompletableFuture.whenComplete((str, exception) -> {
//            if(exception != null){
////                System.out.println("whenComplete ： " + join);
////                exception.printStackTrace();
//            }
//            System.out.println("whenComplete execute whither error throw ");
//        });

//        try {
//            System.out.println("whenComplete ： " + whenCompleteCF.join());
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("whenCom=== "+e);
//        }


//        CompletableFuture<String> completableFutureThenCombine = stringCF.thenCombine(stringCompletableFuture1, (str, str1) -> {
//            return str + str1;
//        });
//        System.out.println("completableFutureThenCombine ： " + completableFutureThenCombine.join());

//        CompletableFuture<String> handle = stringCompletableFuture.handle((str, exception) -> {
//            System.out.println("handle ： " + str);
//            if(exception != null ){
//                System.out.println("stringCompletableFuture1 have exception :" );
//                exception.printStackTrace();
//            }
//            return "handle complete ";
//        });
//
//        System.out.println("handle.join(); ： " + handle.join());

        CompletionStage<Object> test_exception = CompletableFuture.failedStage(new RuntimeException("test exception"));
        CompletableFuture.failedFuture(new RuntimeException("test exception"));

//        stringCompletableFuture.fa
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " CompletableFutureThenRun  last: " + LocalDateTime.now());

        cfS.complete("C");




        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ExecutorService testPool = new ForkJoinPool(10);
//        ExecutorService testPool1 = customerThreadPoolExcuter();
//        List<CompletableFuture<Void>> collect = strings.stream().map(
//                key -> CompletableFuture.runAsync(() -> {
//
//                }, testPool)
//        ).collect(Collectors.toList());


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
