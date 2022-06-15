package com.seccion7.seccion7;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.seccion7.seccion7")
@PropertySource("classpath:sport.properties")
public class SportConfig {
    

    //Define bean for our happy fortune
    @Bean
    public FortuneService getSadFortune(){
        return new SadFortuneService();
    }

    //Define bean for our swim coach and Inject Dependency

    @Bean
    public Coach swimCoach(){
        return new SwimCoach(getSadFortune());
    }

}
