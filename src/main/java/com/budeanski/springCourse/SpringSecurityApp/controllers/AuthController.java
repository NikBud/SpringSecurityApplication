package com.budeanski.springCourse.SpringSecurityApp.controllers;

import com.budeanski.springCourse.SpringSecurityApp.models.Person;
import com.budeanski.springCourse.SpringSecurityApp.services.PeopleService;
import com.budeanski.springCourse.SpringSecurityApp.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator personValidator;
    private final PeopleService peopleService;

    @Autowired
    public AuthController(PersonValidator personValidator, PeopleService peopleService) {
        this.personValidator = personValidator;
        this.peopleService = peopleService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(Model model, @ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult, HttpServletRequest request){
        personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            return "auth/registration";

        peopleService.register(person);

        return "redirect:/auth/login";
    }


}
