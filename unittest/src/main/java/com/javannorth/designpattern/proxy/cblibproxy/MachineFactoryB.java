package com.javannorth.designpattern.proxy.cblibproxy;


public class MachineFactoryB {
    public Machine produceMachineB() {
        System.out.println("machine factory b producing machine.... ");
        return new Machine();
    }
    public Machine repairB(Machine machine) {
        System.out.println("machine b is health.... ");
        return machine;
    }
}
