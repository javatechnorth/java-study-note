package org.javanorth.currency.signal.lockSupport;

import java.util.concurrent.locks.LockSupport;

public class ThreadSignalingLockSupport {
    private static Thread threadA = null;
    private static Thread threadB = null;

    public static void main(String[] args) {
        threadA = new Thread(() -> {
            int i = 1;
            while (i <= 26) {
                System.out.print(i * 2 - 1);
                System.out.print(i * 2);
                i++;
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        });
        threadB = new Thread(() -> {
            char i = 'A';
            while (i <= 'Z') {
                LockSupport.park();
                System.out.print(i);
                i++;
                LockSupport.unpark(threadA);

            }
        });
        threadB.start();
        threadA.start();
    }
}


