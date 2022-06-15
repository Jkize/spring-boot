package com.seccion7.seccion7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RUN {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Coach theCoach = context.getBean("thatSillyCoach", Coach.class); this is with ID
        Coach theCoach = context.getBean(Coach.class);

        Coach theCoach2 = context.getBean("tennisCoach", Coach.class);

        UsingProperties dt = context.getBean(UsingProperties.class);

        System.out.println(dt);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println("Son iguales "+ (theCoach==theCoach2));

        context.close();
    }
}
