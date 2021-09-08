package com.javannorth.designpattern.adapter;

public class Client {
    public static void main(String[] args) {
        Target objectAdaptor = new ObjectAdaptor(new Adaptee());
        objectAdaptor.showPersonalInfo("James","Gosling",66);
        System.out.println("=================");
        Target classAdaptor = new ClassAdaptor();
        classAdaptor.showLastNameAndAge("Gosling",66);
    }
}
