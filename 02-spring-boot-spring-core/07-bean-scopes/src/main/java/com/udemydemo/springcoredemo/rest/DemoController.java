package com.udemydemo.springcoredemo.rest;

import com.udemydemo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("swordCoach") Coach theCoach,
                          @Qualifier("swordCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
