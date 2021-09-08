package com.javannorth.designpattern.proxy.cblibproxy;

import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MachineProxyCglib implements MethodInterceptor {
    public Object getProxyInstance(Class claxx){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(claxx);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("MachineProxyFactory enhancement.....");
        Object object = methodProxy.invokeSuper(o, objects);
        return object;
    }
}
