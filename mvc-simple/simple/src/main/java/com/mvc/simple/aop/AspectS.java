package com.mvc.simple.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AspectS {

    /**
     *  
     */

    // Al methods in the package entity
    @Pointcut("execution(* com.mvc.simple.entity.*.*(..))")
    public void forEntityPackage() {
    };

    // PointCut for getter methods
    @Pointcut("execution(* com.mvc.simple.entity.*.get*(..))")
    private void forEntityGetters() {
    };

    // Pointcut for setter methods
    @Pointcut("execution(* com.mvc.simple.entity.*.set*(..))")
    private void forEntitySetters() {
    };
    // All methods except getters and setter

    @Pointcut("forEntityPackage() && !(forEntityGetters() || forEntitySetters() )  ")
    private void forEntityExceptGetAndSet() {
    };

    @Before("forEntityExceptGetAndSet()")
    private void beforeEntityPackageNoGetAndSet(JoinPoint point) {
        System.out.format("\n====> Método EntityPacakge %s\n%s\n\n", point.getSignature().getName(),
                point.getSignature());
    }

    @Pointcut("execution(* com.mvc.simple.service.*.*(..))")
    public void forServicePackage() {
    };

    @Before("forServicePackage()")
    public void printYes() {
        System.out.println("Using the pointCut");
    }

    @Before("forServicePackage()")
    public void test(JoinPoint point) throws Throwable {
        System.out.format("\n\nOrder 1 --> AspectS EL MÉTODO ES  : %s\n%s\n\n", point.getSignature().getName(), point.getSignature());
        for(Object ob: point.getArgs()){
            System.out.println(ob);
        }

    }

    @Before("execution(public String helloWorld())")
    public void beforeHelloWorld() {
        System.out.println("\n\n======> Executing @Before advice on helloWorld()\n\n");
    }

    /* 
    I have a problem using this because modify the data :(
    @Around("execution(* com.mvc.simple.service.*.*())")
    public void tiempoPasado(ProceedingJoinPoint punto) throws Throwable {

        Long tiempo1 = System.currentTimeMillis();
        punto.proceed();
        Long tiempo2 = System.currentTimeMillis();
        Long total = tiempo2 - tiempo1;

        System.out.format("el metodo es : %s y el tiempo transcurrido %d\n", punto.getSignature().getName(), total);

    }*/

}
