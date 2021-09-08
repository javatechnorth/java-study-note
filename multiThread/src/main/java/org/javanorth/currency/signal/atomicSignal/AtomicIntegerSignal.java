package org.javanorth.currency.signal.atomicSignal;

import org.javanorth.currency.signal.volatilesignal.ThreadSignalingVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSignal {

    private static AtomicInteger threadSignal = new AtomicInteger(1);
    public static void main(String[] args) {

        new Thread(() -> {
            int i = 1;
            while (i <= 26) {
                while(threadSignal.get() == 2){}
                System.out.print(i * 2 - 1);
                System.out.print(i * 2);
                i++;
                threadSignal.set(2);
            }
        }).start();

        new Thread(()->{
            char i = 'A';
            while (i <= 'Z'){
                while (threadSignal.get() == 1){}
                System.out.print(i);
                i++;
                threadSignal.set(1);
            }
        }).start();

    }
}
