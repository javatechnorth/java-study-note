package org.javanorth.currency.lamadaTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionLamadaDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("JavaNorth Runnable");
        }).start();

        List<String> list = new ArrayList<String>();
        List<String> collect = list.stream().map((x) -> {
            return "Java North Function" + x;
        }).collect(Collectors.toList());

        list.forEach(x -> System.out.println( "Java North Consumer test " + x));

        Function strF = (s) -> { return s + "javaNorth"; };
        System.out.println(strF.apply("TEST "));

        Map<String,String> map = new HashMap<>();
        map.forEach((K,V) -> {
            System.out.println("Java North Big Consumer MAP key : " +K + " value: "+V );
        });

        Consumer<String> srtC = (s) -> {System.out.println(s + "javaNorth TEST ");};
        srtC.accept("Hello World");

    }

}
