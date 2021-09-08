package com.javannorth.designpattern.proxy.cblibproxy;


public class MachineFactory implements MachineCompany {
//    @Override
    public Machine produceMachine() {
        System.out.println("machine factory producing machine.... ");
        return new Machine();
    }

//    @Override
    public Machine repair(Machine machine) {
        System.out.println("machine is health.... ");
        return machine;
    }
}
