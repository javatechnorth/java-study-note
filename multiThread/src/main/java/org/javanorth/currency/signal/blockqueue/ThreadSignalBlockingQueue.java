package org.javanorth.currency.signal.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSignalBlockingQueue {
    private static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 1;
            while (i <= 26) {
                System.out.print(i * 2 - 1);
                System.out.print(i * 2);
                i++;
                queue.offer("printChar");
                while(!"printNumber".equals(queue.peek())){}
                queue.poll();
            }
        }).start();

        new Thread(()->{
            char i = 'A';
            while (i <= 'Z'){
                while(!"printChar".equals(queue.peek())){}
                queue.poll();
                System.out.print(i);
                i++;
                queue.offer("printNumber");
            }
        }).start();
    }
}
