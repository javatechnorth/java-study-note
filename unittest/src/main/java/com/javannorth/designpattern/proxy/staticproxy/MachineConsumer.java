package com.javannorth.designpattern.proxy.staticproxy;

public class MachineConsumer {
    public static void main(String[] args) {
        MachineProxy proxy = new MachineProxy();
        proxy.produceMachine();
    }
}
