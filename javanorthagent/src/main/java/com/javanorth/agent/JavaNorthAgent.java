package com.javanorth.agent;

import java.lang.instrument.Instrumentation;

public class JavaNorthAgent {
    //JVM启动时的agent 方法
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain --- agentArgs:" + agentArgs + " |inst:" + inst.toString());
    }
    //  JVM运行中的agent 方法
    public static void agentmain(String agentArgs, Instrumentation inst){
        System.out.println("agentmain --- agentArgs:" + agentArgs + " |inst:" + inst.toString());

    }
}
