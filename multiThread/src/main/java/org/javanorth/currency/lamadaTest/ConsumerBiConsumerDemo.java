package org.javanorth.currency.lamadaTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerBiConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> conString = (x) -> System.out.println(x.toUpperCase());
        conString.accept("i love java north ");

        BiConsumer<String, String> biCon = (x,y) -> System.out.println (x + y);
        biCon.accept("i love ","java");

        List<Person> plist = Arrays.asList(new Person("Java"),new Person("North"));
        acceptAllEmployee(plist,p -> System.out.println(p.name));
        acceptAllEmployee(plist,person -> {person.name = "unknow";});
        acceptAllEmployee(plist,person -> System.out.println(person.name));
    }

    public static void acceptAllEmployee(List<Person> plist, Consumer<Person> con){
        plist.forEach(person -> {con.accept(person);});
    }
}
class Person{
    public String name;
    public Person (String name){
        this.name = name;
    }
}
