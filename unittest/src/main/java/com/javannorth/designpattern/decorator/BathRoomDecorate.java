package com.javannorth.designpattern.decorator;

public class BathRoomDecorate extends HouseDecorator{
    public BathRoomDecorate(House house) {
        super(house);
    }
    public void bathRoomDecoration(){
        house.bathRoomDecoration();
        bathRoomDecorate();
    }
    private void bathRoomDecorate() {
        System.out.println("========鎏金全自动智能宫殿级汤浴场=========");
    }
}
