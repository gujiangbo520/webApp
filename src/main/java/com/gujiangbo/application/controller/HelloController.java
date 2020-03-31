package com.gujiangbo.application.controller;

import com.gujiangbo.application.config.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${person.name}")
    private String name;

    @Autowired
    private Person person;

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello(){
        return name +" hello world !";
    }

    @ResponseBody
    @RequestMapping("/showPerson")
    public String showPerson(){
        return person.toString();
    }
}
