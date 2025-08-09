package com.north.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateTest {
    static ExecutorService threadPool = Executors.newFixedThreadPool(20);

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        for(int i=0;i<200;i++){
            threadPool.execute(()->{
                try {
                    System.out.println(format.parse("2021-07-09 16:29:21"));
                } catch (ParseException e) {
                    e.printStackTrace();
                };
            });
        }
    }

}
