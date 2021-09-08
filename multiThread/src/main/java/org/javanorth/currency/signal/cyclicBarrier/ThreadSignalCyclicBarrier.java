package org.javanorth.currency.signal.cyclicBarrier;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSignalCyclicBarrier {
    private static List<String> list =  Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(2,barrierRun());

        new Thread(() -> {
            int i = 1;
            while (i <= 26) {
                list.add(String.valueOf(i * 2 - 1));
                list.add(String.valueOf(i * 2));
                i++;
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            char i = 'A';
            while (i <= 'Z'){
                try {
                    list.add(String.valueOf(i));
                    i++;
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public static Runnable barrierRun(){
        return new Runnable() {
            @Override
            public void run() {
                Collections.sort(list);
                list.forEach(str->System.out.print(str));
                list.clear();
            }
        };
    }
}
