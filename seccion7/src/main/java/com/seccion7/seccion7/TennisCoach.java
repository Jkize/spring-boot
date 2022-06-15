package com.seccion7.seccion7;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") //WithID
@Component
@Scope("prototype") //New instance every time. When we have the "prototype" this doesn't call the method @PreDestroy but we can use, using the DisposableBean interface ;)
public class TennisCoach implements Coach, DisposableBean{

    @Autowired
    @Qualifier("randomFortuneService") //This is very important when we have a lot of class with the same implementation. This annotation can put in constructor, setter and filed
    private FortuneService fortuneService;

    /*
    This is injection with constructor
    @Autowired
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }*/

    /**
     * This is injection with setter
     * In this case no matter the name of the function
     * @param fortuneService
     */
    /*
    @Autowired
    public void alvService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: Inside setFortuneService ;)");
        this.fortuneService = fortuneService;
    }
    */

    @PostConstruct
    public void doMyWork(){
        System.out.println("Inicializa esta instancia papu");
    }

    @PreDestroy //Wi
    public void finishMyWork(){
        System.out.println("Finaliza esta instancia papu");
    }

    @Override
    public String getDailyWorkout() {
       return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
      return this.fortuneService.getFortune();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Se ha destruido :C");
        
    }
    
}
