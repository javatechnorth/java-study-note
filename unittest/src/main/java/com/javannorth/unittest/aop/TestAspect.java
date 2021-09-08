package com.javannorth.unittest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Aspect
@Component
public class TestAspect {

    @Pointcut(value = "@annotation(AOPTest)")
    public void pointcut() {
    }

//    @Pointcut("execution(public * *(..))")
//    private void anyPublicOperation() {}
//
//    @Pointcut("within(com.xyz.myapp.trading..*)")
//    private void inTrading() {}
//
//    @Pointcut("anyPublicOperation() && inTrading()")
//    private void tradingOperation() {}

    @Before(value = "pointcut()")
    public void  aopBeforeTest(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.2 Before Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }

    @Order(-2)
    @Before(value = "pointcut()")
    public void  aopBeforeN2Test(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.2 Before -2 Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }
    @Order(-1)
    @Before(value = "pointcut()")
    public void  aopBeforeN1Test(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.2 Before -1 Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }
    @Order(0)
    @Before(value = "pointcut()")
    public void  aopBefore0Test(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.2 Before 0 Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }
    @Order(1)
    @Before(value = "pointcut()")
    public void  aopBefore1Test(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.2 Before 1 Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }
//    @Order

    @After(value = "pointcut()")
    public void  aopAfterTest(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.4 After Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }

    @AfterReturning(value = "pointcut()")
    public void  aopAfterReturningTest(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.3 AfterReturning Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }

    @AfterThrowing(value = "pointcut()")
    public void  aopAfterThrowingTest(JoinPoint joinPoint) throws Throwable {
        System.out.println("NO.3 AfterThrowing Advice " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
    }

    @Around(value = "pointcut()")
    public Object  aopTest(ProceedingJoinPoint  joinPoint) throws Throwable {

        System.out.println("NO.1 Around Advice : before proceed - " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
        Object object = joinPoint.proceed();
        System.out.println("NO.5 Around Advice : after proceed - " +joinPoint.getSignature().getName()+":"+
                joinPoint.getSignature().getDeclaringTypeName());
        return object;
    }
}
