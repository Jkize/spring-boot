package seccion4;

import seccion4.interfaces.Coach;
import seccion4.interfaces.FortuneService;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService s) {
        this.fortuneService = s;
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball 54";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}