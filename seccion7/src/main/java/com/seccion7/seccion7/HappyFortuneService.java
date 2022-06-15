package com.seccion7.seccion7;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "100 Because you are Happy Fortune Service ;)";
    }
    
}
