package com.mvc.simple.service;

import java.util.ArrayList;
import java.util.List;
 

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public List<String> getUsers(boolean withError ) {

        if(withError){
            throw new RuntimeException("No soup for you!!!");
        }
        List<String> array = new ArrayList<>();
        array.add("Jhoan");
        array.add("Saavedra");
        return array;
    }
 
}
