package org.javanorth.currency.thread;

public class ThreadTest1 {
    private static Object obj = new Object();
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.start();
        t2.start();
        t3.start();
        try {
            System.out.println(Thread.currentThread().getName()+" : sleep(3000)");
            Thread.sleep(3000);
            t1.getState();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            obj.notifyAll();
        }
    }

    static class ThreadA extends Thread{

        public ThreadA(String name){
            super(name);
        }
        public void run() {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    // 唤醒当前的wait线程
                    obj.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
