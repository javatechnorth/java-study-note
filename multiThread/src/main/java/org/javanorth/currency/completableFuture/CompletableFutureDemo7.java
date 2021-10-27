package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo7 {
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

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            System.out.println(LocalDateTime.now() + " 正在取快递！ ");
            try {Thread.sleep(2 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            return "快递";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println(LocalDateTime.now() + " 女朋友正在买菜！ ");
            try {Thread.sleep(4 * 1000);} catch (InterruptedException e) {e.printStackTrace();}
            return "蔬菜";
        });

        cf1.acceptEither(cf2,(str1 )->{
            System.out.println(LocalDateTime.now() +  " ["+ str1 +"] 带回来了，先回家吧 ");
        }).join();
//        cf1.thena
        cf1.thenAcceptBoth(cf2,(str1 ,str2 )->{
            System.out.println(LocalDateTime.now() +  " ["+ str1 + "]["+str2+"] 带回来了，开始做饭 ");
        }).join();

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
