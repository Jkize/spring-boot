package com.mvc.seccion11.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
      // inject via application.properties
      @Value("${welcome.message}")
      private String message = "";
  
      @RequestMapping("/") 
      public String index(Model model) {
          model.addAttribute("greeting", message+"!");
          return "index";
      }
}
