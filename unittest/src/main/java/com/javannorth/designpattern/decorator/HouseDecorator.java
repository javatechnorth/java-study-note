package com.javannorth.designpattern.decorator;

public abstract class HouseDecorator  implements House{
    House  house;
    public HouseDecorator(House house) {
        this.house = house;
    }
    public void bathRoomDecoration(){
        house.bathRoomDecoration();
    }
    public void bedRoomDecoration(){
        house.bedRoomDecoration();
    }

}
