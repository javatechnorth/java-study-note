package com.javannorth.designpattern.adapter;

public class ObjectAdaptor implements Target{

    private AdapteeInterface adaptee;

    public ObjectAdaptor(AdapteeInterface adaptee) {
        this.adaptee = adaptee;
    }

    public void showPersonalInfo(String firstName , String lastName, int age){
        showFullName(firstName,lastName);
        showLastNameAndAge(lastName,age);
    }

    @Override
    public void showFullName(String firstName , String lastName) {
        System.out.println("ObjectAdaptor showFullName firstName："+firstName+" lastName: "+lastName);
        adaptee.showLastName(lastName);
    }

    @Override
    public void showLastNameAndAge(String lastName, int age) {
        System.out.println("ObjectAdaptor showLastNameAndAge  ， lastName："+lastName+" age: "+age);
        adaptee.showAge(age);
    }
}
