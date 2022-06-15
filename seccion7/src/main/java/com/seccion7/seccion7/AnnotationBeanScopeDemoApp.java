package com.seccion7.seccion7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean(Coach.class);

        Coach alphaCoach = context.getBean(Coach.class);

        System.out.println("\nPointing to the same object: "+ (theCoach == alphaCoach));
        System.out.println("\nMemory location for theCoach "+theCoach);
        System.out.println("\nMemory location for alphaCoach: "+alphaCoach+"\n");
        context.close();
    }
}
