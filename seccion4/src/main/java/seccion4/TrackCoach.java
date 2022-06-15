package seccion4;

import seccion4.interfaces.Coach;
import seccion4.interfaces.FortuneService;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(){
        System.out.println("INIT in the construction");
    }

    public TrackCoach(FortuneService s) {
        this.fortuneService = s;
    }


    @Override
    public String getDailyWorkout() { 
        return "TrackCOuach 54";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }



    //add an init method
    //any name

    public void doInitXD(){
        System.out.println("INITTTTTTTTTTTTTTTTTTT");
    }

    public void doDestroytXD(){
        System.out.println("OMG Destroy it!!!");
    }


    //add a destroy method 


    
}
