package com.mvc.simple.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AspectLog {

    @Pointcut("execution(* com.mvc.simple.service.UserService.getUsers(..)) ")
    public void getUserInService() {
    }

    @AfterReturning(pointcut = "getUserInService()", returning = "users")
    public void afterReturningFindUsers(
            JoinPoint joinPoint, List<String> users) {

        System.out.println("\n====> Executing @AfterReturning on method" + joinPoint.getSignature().getName());
        System.out.println("====> print returning" + users + "\n");

        // BE CAREFULL WE CAN MODIFY THE DATA
        users.set(0, "Modify Data xD");
    }

    @AfterThrowing(pointcut = "getUserInService()", throwing = "error")
    public void afterThrowingFindAcccountsAdvice(
            JoinPoint joinPoint, Throwable error) {

        System.out.println("\n====> Executing @AfterThrowing on method" + joinPoint.getSignature().getName());
        System.out.println("====> print error" + error + "\n");

    }

    @Before("com.mvc.simple.aop.AspectS.forServicePackage()")
    public void test(JoinPoint point) throws Throwable {
        System.out.format("\n\nOrder 2 --> AspectLog EL MÉTODO ES  : %s\n%s\n\n", point.getSignature().getName(),
                point.getSignature());

    }

}
