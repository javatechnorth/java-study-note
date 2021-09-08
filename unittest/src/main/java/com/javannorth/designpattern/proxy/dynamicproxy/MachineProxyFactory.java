package com.javannorth.designpattern.proxy.dynamicproxy;

import com.javannorth.designpattern.proxy.staticproxy.MachineCompany;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MachineProxyFactory {
    private Object target;
    public MachineProxyFactory(Object object) {
        this.target = object;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("machine proxy find factory for machine .... ");
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });
    }
}
