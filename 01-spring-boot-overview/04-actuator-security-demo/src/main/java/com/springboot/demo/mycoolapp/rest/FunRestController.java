package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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

}
