package org.javanorth.currency.completableFuture;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo4 {
    public static void main(String[] args) {


        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(" completableFuture start: " +LocalDateTime.now());
            try {
                System.out.println(" CompletableFuture supplyAsync Thread name: "+Thread.currentThread().getName());
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "java North";
        });

        stringCompletableFuture.thenAcceptAsync((str)->{
            System.out.println(" CompletableFuture thenAcceptAsync Thread name: "+Thread.currentThread().getName());
            System.out.println(" CompletableFuture "+str);
            System.out.println(" completableFuture finish: " +LocalDateTime.now());
        });

        System.out.println(" completableFuture code end: " +LocalDateTime.now());
        while(!stringCompletableFuture.isDone()){

        }

        try {

            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("  end all: " +LocalDateTime.now());
        System.out.println(" CompletableFuture Thread name: "+Thread.currentThread().getName());

    }
}
