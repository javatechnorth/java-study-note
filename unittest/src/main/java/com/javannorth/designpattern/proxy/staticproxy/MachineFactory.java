package com.javannorth.designpattern.proxy.staticproxy;

public class MachineFactory implements MachineCompany{
    @Override
    public Machine produceMachine() {
        System.out.println("machine factory producing machine.... ");
        return new Machine();
    }
}
