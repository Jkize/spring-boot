package com.seccion7.seccion7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        
        
        SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
        System.out.println(theCoach.getDailyFortune() + " "+  theCoach.getEmail());
        context.close();
    }
}
