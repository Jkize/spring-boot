package com.seccion7.seccion7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsingProperties {
    
    
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public String getEmail() {
        return email;
    }
    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return email+" "+team;
    }

}
