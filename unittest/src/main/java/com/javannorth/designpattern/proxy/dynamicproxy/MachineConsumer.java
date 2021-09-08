package com.javannorth.designpattern.proxy.dynamicproxy;


public class MachineConsumer {
    public static void main(String[] args) {
        MachineCompany target = new MachineFactory();
        MachineCompany machineCompany = (MachineCompany) new MachineProxyFactory(target).getProxy();
        Machine machine = machineCompany.produceMachine();
        machineCompany.repair(machine);
    }
}
