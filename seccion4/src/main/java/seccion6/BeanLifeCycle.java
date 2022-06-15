package seccion6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import seccion4.interfaces.Coach;

public class BeanLifeCycle {
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        //Coach baseball = context.getBean("myCricketCoach",Coach.class);
        Coach theCoach = context.getBean("myCoach",Coach.class);
        System.out.println(theCoach.getDailyFortune());
        context.close();
    }
}
 