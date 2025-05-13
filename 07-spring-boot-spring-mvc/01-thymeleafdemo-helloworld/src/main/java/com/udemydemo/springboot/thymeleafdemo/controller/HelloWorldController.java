package com.udemydemo.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //method to show initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //method to read form data and data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Hello! " + theName;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }


    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model){

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Greetings from v3! " + theName;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }


}
