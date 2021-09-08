package com.javannorth.designpattern.proxy.staticproxy;

import java.util.Objects;

public class MachineProxy implements MachineCompany{
    private MachineCompany machineCompany;
    public MachineProxy() {
    }

    @Override
    public Machine produceMachine() {
        System.out.println("machine proxy get order .... ");
        System.out.println("machine proxy start produce .... ");
        if(Objects.isNull(machineCompany)){
            System.out.println("machine proxy find factory .... ");
            machineCompany = new MachineFactory();
        }
        return machineCompany.produceMachine();
    }
}
