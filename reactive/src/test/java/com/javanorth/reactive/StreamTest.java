package com.javanorth.reactive;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamTest1(){
        String[] strArray = {"ss","ss","","sdffg"};

        Arrays.stream(strArray).forEach(System.out::println);
        Arrays.asList(strArray).stream().forEach(System.out::println);
        Stream.of(strArray).forEach(System.out::println);
        Stream.iterate(1,(i) -> i+1).limit(10).forEach(System.out::println);
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.out::println);

        String[] strArray1 = {"ss","ss","","sdffg","bca-de","fff"};

        String collect = Stream.of(strArray1)
                .filter(i -> !i.isEmpty())
                .sorted()
                .limit(1)
                .map(i -> i.replace("-", ""))
                .flatMap(i -> Stream.of(i.split("")))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(collect);
//                .forEach(System.out::println);

    }
}
