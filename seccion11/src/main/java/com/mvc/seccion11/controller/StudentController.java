package com.mvc.seccion11.controller;

import com.mvc.seccion11.model.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    

    @RequestMapping("/showForm")
    public String showForm(Model theModel){

        theModel.addAttribute("student",new Student() );
            
        return "forms/student-form";
    }
     
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println(theStudent.getFirstName()+" "+theStudent.getLastName());
        return "forms/student-confirmation";
    }


}
