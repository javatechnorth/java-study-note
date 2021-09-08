package com.javannorth.designpattern.adapter;

public class ClassAdaptor extends Adaptee implements Target{

    @Override
    public void showFullName(String firstName, String lastName) {
        System.out.println("ClassAdaptor showFullName firstName："+firstName+" lastName: "+lastName);
        super.showLastName(lastName);
    }

    @Override
    public void showLastNameAndAge(String lastName, int age) {
        System.out.println("ClassAdaptor showLastNameAndAge  ， lastName："+lastName+" age: "+age);
        super.showAge(age);
    }

    @Override
    public void showPersonalInfo(String firstName, String lastName, int age) {
        this.showFullName(firstName,lastName);
        this.showLastNameAndAge(lastName,age);
    }
}
