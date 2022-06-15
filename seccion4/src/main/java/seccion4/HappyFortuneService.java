package seccion4;

import seccion4.interfaces.FortuneService;

public class HappyFortuneService  implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day";
    }   
    

}
