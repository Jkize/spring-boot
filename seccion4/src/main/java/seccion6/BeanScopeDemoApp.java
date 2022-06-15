package seccion6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import seccion4.interfaces.Coach;

public class BeanScopeDemoApp {
    
    public static void main(String[] args) {
     
        //Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        //Coach baseball = context.getBean("myCricketCoach",Coach.class);
        Coach theCoach = context.getBean("myCoach",Coach.class);
        Coach theCoach2 = context.getBean("myCoach",Coach.class); 


        boolean result = theCoach ==theCoach2; //If these are the same. It will return true because it's a singleton 

        System.out.println( "\nPointing to the same object "+ result);
        System.out.println("\nMemory location for theCoach "+ theCoach);
        
        System.out.println("\nMemory location for theCoach2 "+ theCoach2 +"\n");
        context.close();
    }
}
