package com.javannorth.designpattern.decorator;

public class BedRoomDecorator extends HouseDecorator{
    public BedRoomDecorator(House house) {
        super(house);
    }
    public void bedRoomDecoration(){
        house.bedRoomDecoration();
        bedRoomDecorate();
    }
    private void bedRoomDecorate() {
        System.out.println("========全智能温控深度睡眠房=========");
    }
}
