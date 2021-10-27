package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureDemo8 {
    public static void main(String[] args) {
//        CompletableFuture<Integer> cf1 = CompletableFuture.completedFuture(2);
//        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
//        cf1.thenApplyAsync(x->square(x))//Function 有输入有输出
//                .thenAcceptAsync(x -> System.out.println(x)) // Consumer 有输入没有输出
//                .thenRunAsync(() -> System.out.println("javaNorth all complete "));// Runnable 仅执行
//
//        System.out.println("javaNorth-cf1 complete ");
//        cf1.complete(2);
//
//                Throwable throwable = new RuntimeException("test");
//        CompletableFuture.failedStage(throwable);
//        Executor executor = CompletableFuture.delayedExecutor(5l, TimeUnit.SECONDS);
////        CompletableFuture.
//
//        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(()->{
//            try {Thread.sleep(2 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
//            return "supplyAsync1";
//        });
//        CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
//            try {Thread.sleep(4 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
//            return "supplyAsync2";
//        });

//        CompletableFuture.allOf(supplyAsync1,supplyAsync2).thenRun(()->{
//            System.out.println(LocalDateTime.now().getSecond() + " allof complete ");
//        });
//        CompletableFuture.anyOf(supplyAsync1,supplyAsync2).thenRun(()->{
//            System.out.println(LocalDateTime.now().getSecond() + " anyOf complete ");
//        });

        CompletableFuture<List<String>> cf1 = CompletableFuture.supplyAsync(()->{
            List<String> strings = Arrays.asList("看电影", "打扑克");
            System.out.println(LocalDateTime.now() + " 晚饭后女朋友说，想要： " + strings);
            try {Thread.sleep(2 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            return strings;
        });
        CompletableFuture<List<String>> cf2 = CompletableFuture.supplyAsync(()->{
            List<String> strings = Arrays.asList("看电影", "打游戏");
            System.out.println(LocalDateTime.now() + " 晚饭后，我想： " + strings);
            try {Thread.sleep(4 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            return strings;
        });

        cf1.thenCombine(cf2,(list1,list2) -> {
            List<String> collect = list1.stream().filter(str -> list2.contains(str)).collect(Collectors.toList());
            System.out.println(LocalDateTime.now() + " 综合我们两个人的想法，最终决定： " + collect);
            return collect;
        }).join();

//        try {Thread.sleep(10 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
//        cf2.join();

//        .thenApply((str) -> {
//            System.out.println(LocalDateTime.now() + " 拿到了： "+str);
//            System.out.println(LocalDateTime.now() + " 买菜中。。。 ");
//            try {Thread.sleep(2 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
//            return str + " 和 蔬菜";
//        }).thenApply((str2)->{
//            System.out.println(LocalDateTime.now() + " 现在有了： ["+str2+"]");
//            try {Thread.sleep(2 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
//            return "带着 [" + str2 + " ]回家做饭" ;
//        });


//        System.out.println( LocalDateTime.now() + " 美好的一天： "+ cf.join());



    }

    private static Object square(Integer x) {
        return x * x;
    }
}
