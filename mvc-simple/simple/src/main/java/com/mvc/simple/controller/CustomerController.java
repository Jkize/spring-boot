package com.mvc.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.simple.entity.CustomerEntity;
import com.mvc.simple.service.CustomerService;
import com.mvc.simple.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    UserService userService;
 

    @GetMapping("/initAOP")
    public String initAOP(Model model) {

        this.customerService.manipulatedObject();
        model.addAttribute("customers", null);
        return "list-customers";
    }

    @GetMapping("/list")
    public String listCustomer(Model model) {
        List<CustomerEntity> data = customerService.getList();
        model.addAttribute("customers", data);
        return "list-customers";
    }

    @GetMapping("/advice")
    public String getAdvice(Model model) {
        this.customerService.helloWorld();
        return "advice";
    }

    @GetMapping("/add")
    public String add() {
        this.customerService.addSome();
        return "addSomething";
    }

    @GetMapping("/update")
    public String updateSomething() {
        this.customerService.updateSome("Este es del argumento ;)");
        return "updateSome";
    }

    @GetMapping("/getUsers")
    public String getUsers(){
       List<String>  users= this.userService.getUsers(false);
       System.out.println("\n===> User since CustomerController "+ users);

       try {
        this.userService.getUsers(false);
       } catch (Exception e) {
        System.out.println("\n===> Error find"+e);
       }

        return "users";
    }
}
