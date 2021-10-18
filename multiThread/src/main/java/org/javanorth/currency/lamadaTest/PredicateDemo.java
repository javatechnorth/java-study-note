package org.javanorth.currency.lamadaTest;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (s) -> s > 5;
        Predicate<Integer> predicate2 = (s) -> s > 8;
        System.out.println(" 3 大于5 ？ " + predicate.test(3));
        System.out.println(" 6 大于5 ？ " + predicate.test(6));

        System.out.println("7 大于5 and 大于8 " + predicate.and(predicate2).test(7));
        System.out.println("7 大于5 or 大于8 " + predicate.or(predicate2).test(7));

        List<Integer> list = Arrays.asList(3,5,6,2,8,4,7,9);
        List<Integer> collect = list.stream().filter(predicate).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(collect);
    }
}
