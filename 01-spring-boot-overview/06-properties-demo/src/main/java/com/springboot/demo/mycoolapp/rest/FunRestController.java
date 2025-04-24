package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // "/" returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/products")
    public String getProducts() {
        return "This is the products.";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        System.out.println("Hello World");
        return "Coach: " + coachName + " Team: " + teamName;
    }

}
