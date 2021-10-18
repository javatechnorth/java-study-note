package org.javanorth.currency.thread;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class ThreadLocalTest {

    static Map<WeakReference<String>,String> weakMap;
    static Map<String,String> strongMap;

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalTest test = new ThreadLocalTest();
        test.weskTest();

        System.out.println("before gc weakMap size:"+weakMap.size());
        System.out.println("before gc strongMap size:"+strongMap.size());
        System.out.println("gc---");
        System.gc();

        Thread.sleep(1000*6);

        System.out.println("after gc weakMap size: "+weakMap.size());
        System.out.println("after gc strongMap size: "+strongMap.size());

    }

    private void weskTest() {
        weakMap = new WeakHashMap<>();
        strongMap = new HashMap<>();
        String key = new String("key");
        String value = new String("value");
        weakMap.put(new WeakReference<>(key),value);
        strongMap.put(key,value);



    }

}
