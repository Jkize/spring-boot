package seccion4;

import seccion4.interfaces.Coach;
import seccion4.interfaces.FortuneService;

public class CricketCoach implements Coach {
    
    private FortuneService fortuneService;

    private String emailAddress;
    private String team;

    //Create a no-arg constructor
    public CricketCoach(){

    }

    public void setTeam(String team) {
        this.team = team;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getTeam() {
        return team;
    }
    
    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method- setEmail "+emailAddress);
        this.emailAddress = emailAddress;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method- setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {        
        return "Dayli CricketCoach";
    }

    @Override
    public String getDailyFortune() { 
        return this.fortuneService.getFortune();
    }

}
