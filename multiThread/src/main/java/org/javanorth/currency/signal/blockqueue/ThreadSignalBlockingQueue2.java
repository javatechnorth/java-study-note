package org.javanorth.currency.signal.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSignalBlockingQueue2 {
    private static LinkedBlockingQueue<String> queue1 = new LinkedBlockingQueue<>();
    private static LinkedBlockingQueue<String> queue2 = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 1;
            while (i <= 26) {
                System.out.print(i * 2 - 1);
                System.out.print(i * 2);
                i++;
                try {
                    queue2.put("printChar");
                    queue1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            char i = 'A';
            while (i <= 'Z'){
                try {
                    queue2.take();
                    System.out.print(i);
                    i++;
                    queue1.put("printNumber");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
