package com.seccion7.seccion7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach theCoach = context.getBean(Coach.class);
        Coach alphaCoach = context.getBean(Coach.class);
        System.out.println("\nPointing to the same object: "+ (theCoach == alphaCoach));
        System.out.println("\nMemory location for theCoach "+theCoach);
        System.out.println("\nMemory location for alphaCoach: "+alphaCoach+"\n");
        context.close();
    }
}
