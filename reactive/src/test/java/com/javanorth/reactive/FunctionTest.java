package com.javanorth.reactive;

import org.junit.jupiter.api.Test;

import java.util.function.*;

public class FunctionTest {

    @Test
    public void functionTest(){

        Consumer consumer = (i)-> System.out.println("this is " + i);
        consumer.accept("consumer");

        Supplier supplier  = () -> "this is supplier";
        System.out.println(supplier.get());

        Function<Integer,Integer> function = (i) -> i*i;
        System.out.println(function.apply(8));

        BiFunction<Integer,Integer,String> biFunction = (i,j)-> i+"*"+j+"="+i*j;
        System.out.println(biFunction.apply(8,8));

        Predicate<Integer> predicate = (i) -> i.intValue()>3;
        System.out.println(predicate.test(5));



    }
}
