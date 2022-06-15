package com.mvc.seccion11.controller;

import javax.validation.Valid;

import com.mvc.seccion11.model.Customer;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder .. to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for out validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringT = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringT);
    }

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "forms/customer-form";
    }

    @RequestMapping("/processForm")
    public String provessForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {

        System.out.println(theBindingResult);
        if (theBindingResult.hasErrors()) {
            return "forms/customer-form";
        }
        return "forms/customer-confirmation";
    }

}
