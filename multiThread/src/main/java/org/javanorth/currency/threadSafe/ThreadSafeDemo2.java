package org.javanorth.currency.threadSafe;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeDemo2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i =0 ;i< 20 ;i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    list.add(Thread.currentThread().getName() + j);
                }
            }, "thread" + i).start();
        }
        Thread.sleep(1000*3);
        System.out.println(list.size());
    }
}
