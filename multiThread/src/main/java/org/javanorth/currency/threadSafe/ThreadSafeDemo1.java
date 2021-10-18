package org.javanorth.currency.threadSafe;

public class ThreadSafeDemo1 {
    static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i =0 ;i< 20 ;i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    printCount();
                }
            }, "thread" + i).start();
        }
        Thread.sleep(1000 * 3);
        System.out.println("final count:" + count);
    }
    public static void printCount( ){
        count ++ ;
    }
}
