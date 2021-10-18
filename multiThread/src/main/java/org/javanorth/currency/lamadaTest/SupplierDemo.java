package org.javanorth.currency.lamadaTest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        SupplierDemo sdemo = new SupplierDemo();
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime localDateTime = s.get();
        System.out.println(s.get());


        Supplier<List> listSupplier = sdemo.listSupplier();
        List list = listSupplier.get();

        Person person = personFactory(Person::new);
        System.out.println(person);

        Person javaNorth = personFactory(() -> new Person("JavaNorth"));
        System.out.println(javaNorth);


        Supplier<String> srtP = () -> {return "I love avaNorth ";};
        System.out.println(srtP.get());


    }

    public Supplier<List> listSupplier(){
        return ArrayList::new;
    }


    public static Person personFactory(Supplier<? extends Person> s){
        Person person = s.get();

        if(person.getName() == null)  person.setName("default");
        person.setAge(18);
        return person;
    }


    static class Person {
        String name;
        int age;

        public Person() {

        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

