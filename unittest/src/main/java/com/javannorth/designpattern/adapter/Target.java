package com.javannorth.designpattern.adapter;

public interface Target {
    void showFullName(String firstName , String lastName);
    void showLastNameAndAge(String lastName, int age);
    void showPersonalInfo(String firstName , String lastName, int age);
}
