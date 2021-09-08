package com.javannorth.designpattern.proxy.cblibproxy;


public class MachineConsumer {
    public static void main(String[] args) {

        MachineCompany machineFactory = (MachineCompany) new MachineProxyCglib().getProxyInstance(MachineFactory.class);
        Machine machine = machineFactory.produceMachine();
        machineFactory.repair(machine);
        System.out.println("==============================");

        MachineFactoryB machineFactoryB = (MachineFactoryB) new MachineProxyCglib().getProxyInstance(MachineFactoryB.class);
        Machine machineB = machineFactoryB.produceMachineB();
        machineFactoryB.repairB(machineB);
    }
}
