package org.javanorth.currency.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo3 {
    public static void main(String[] args) {
//        CompletableFuture<Integer> cf1 = CompletableFuture.completedFuture(2);
        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
        cf1.thenApplyAsync(x -> square(x))//Function 有输入有输出
                .thenAcceptAsync(x -> System.out.println(x)) // Consumer 有输入没有输出
                .thenRunAsync(() -> System.out.println("javaNorth all complete "));// Runnable 仅执行

//        CompletableFuture<Integer> integerCompletableFuture = cf1.completeAsync(() -> square(2));
        System.out.println("javaNorth-cf1 complete ");
        cf1.complete(2);
    }

    private static Object square(Integer x) {
        return x * x;
    }
}
