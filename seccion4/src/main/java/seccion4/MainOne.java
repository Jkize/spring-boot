package seccion4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainOne {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Coach baseball = context.getBean("myCricketCoach",Coach.class);
        CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);

        
        System.out.println(theCoach.getDailyWorkout() +"\n"+ theCoach.getDailyFortune() + "\n"+theCoach.getTeam() + "\n"+theCoach.getEmailAddress());
        context.close();
    }

}