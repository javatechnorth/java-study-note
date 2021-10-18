package org.javanorth.currency.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo1 {
    public static void main(String[] args) {

        CompletableFuture<String> cf1 = new CompletableFuture<String>();
        CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("completedFuture");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "supplyAsyncFuture";
        });
        CompletableFuture<Void> runAsyncCompleteableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("runAsyncCompleteableFuture");
        });
    }
}
