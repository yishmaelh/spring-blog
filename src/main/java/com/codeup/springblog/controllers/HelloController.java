package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @GetMapping("/")
//    @ResponseBody
//    public String HelloWorld(){
//        return "Hello from Spring Boot.";
//    }

    @GetMapping("/helloWorld/{username}")
    @ResponseBody
    public String helloFromSpring(@PathVariable String username){
        return "Hello, " + username + "!";
    }
}
