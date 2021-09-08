package com.javannorth.designpattern.decorator;

public class Villa implements House{
    @Override
    public void bathRoomDecoration() {
        System.out.println("别墅豪华卫生间装修");
    }
    @Override
    public void bedRoomDecoration() {
        System.out.println("别墅豪华卧室装修");
    }
}
