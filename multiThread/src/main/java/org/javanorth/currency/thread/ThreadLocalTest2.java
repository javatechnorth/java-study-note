package org.javanorth.currency.thread;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest2 {


    private static final ThreadLocal<String> CONTEXHOLDER = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalTest2 test = new ThreadLocalTest2();
        ThreadLocal key = new ThreadLocal();

        CONTEXHOLDER.set("CONTEXHOLDER");
        key.set("main ThreadLocalKey");

//        key = null;
        Thread threadBefore = Thread.currentThread();

//        Thread thread = new Thread(() -> {
//
//            System.out.println(key.get());
//            System.out.println("new CONTEXHOLDER1 "+CONTEXHOLDER.get());
//
//            key.set("new ThreadLocalKey");
//            CONTEXHOLDER.set("new CONTEXHOLDER");
//
//            System.out.println(key.get());
//            System.out.println("new CONTEXHOLDER:"+CONTEXHOLDER.get());
//            System.gc();
//            try {
//                Thread.sleep(1000*6);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Thread newthread = Thread.currentThread();
//            System.out.println(key.get());
//            System.out.println("new CONTEXHOLDER:"+CONTEXHOLDER.get());
//
//        });
//
//        thread.start();
        System.out.println("thread.start---");
        key.remove();
        Thread.sleep(1000*2);
        System.out.println("gc---");
        System.gc();
        Thread.sleep(1000*6);

        Thread threadAfter = Thread.currentThread();

        System.out.println("main thread: "+key.get());
        System.out.println("main thread CONTEXHOLDER:"+CONTEXHOLDER.get());

        System.out.println("end");


    }


}
