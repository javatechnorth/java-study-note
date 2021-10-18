package org.javanorth.currency.thread;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class ThreadLocalTest1 {

    static Map<WeakReference<ThreadLocal>,String> weakMap;
    static Map<ThreadLocal,String> strongMap;

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalTest1 test = new ThreadLocalTest1();
        ThreadLocal key = new ThreadLocal();
        test.weskTest(key);
        key = null;
        Thread threadBefore = Thread.currentThread();
        System.out.println("before gc weakMap size:"+weakMap.size());
        System.out.println("before gc strongMap size:"+strongMap.size());
        System.out.println("gc---");
        System.gc();

        Thread.sleep(1000*6);
        Thread threadAfter = Thread.currentThread();
        System.out.println("after gc weakMap size: "+weakMap.size());
        System.out.println("after gc strongMap size: "+strongMap.size());

        Collections.unmodifiableMap(strongMap);

    }

    private void weskTest(ThreadLocal key) {
        weakMap = new HashMap<>();
        strongMap = new HashMap<>();
//        String key = new String("key");

        String value = new String("value");
        weakMap.put(new WeakReference<>(key),value);
        strongMap.put(key,value);
        weakMap.get(key);

        key.set("test");

        key = null;




    }

}
