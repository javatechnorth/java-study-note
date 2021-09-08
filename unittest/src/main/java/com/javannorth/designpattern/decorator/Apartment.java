package com.javannorth.designpattern.decorator;

public class Apartment implements House{
    @Override
    public void bathRoomDecoration() {
        System.out.println("[小两室，实用雅致卫生间装修]");
    }
    @Override
    public void bedRoomDecoration() {
        System.out.println("[小两室，温暖小窝装修]");
    }
}
