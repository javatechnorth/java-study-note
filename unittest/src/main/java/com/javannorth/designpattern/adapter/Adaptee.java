package com.javannorth.designpattern.adapter;

public class Adaptee implements AdapteeInterface{
    public void showLastName(String lastName){
        System.out.println("Adapted showLastName ! Hello Mr." + lastName);
    }
    public void showAge(int age){
        System.out.println("Adapted showAge, age is :" + age);
    }
}
