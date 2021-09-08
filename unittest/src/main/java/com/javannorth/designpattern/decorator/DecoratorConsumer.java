package com.javannorth.designpattern.decorator;

import java.io.*;

public class DecoratorConsumer {
    public static void main(String[] args) throws IOException {
        House myHouse = new Apartment();
        HouseDecorator roomDecorate = new BedRoomDecorator(myHouse);
        roomDecorate = new BathRoomDecorate(roomDecorate);

        System.out.println("--------看看卧室搞成什么样子--------");
        roomDecorate.bedRoomDecoration();

        System.out.println();
        System.out.println("--------看看卫生间整成什么样子--------");
        roomDecorate.bathRoomDecoration();

        InputStream fileInput = new FileInputStream(new File("src/main/resources/input.txt"));
        BufferedInputStream bufferInput = new BufferedInputStream(fileInput);

        int read = bufferInput.read();
        byte [] inputBufferArray = new byte [8192];
        bufferInput.read(inputBufferArray,0,read);
//        System.out.println("read length"+ read);
//        System.out.println("read"+ new String(inputBufferArray,"UTF-8"));

    }
}
