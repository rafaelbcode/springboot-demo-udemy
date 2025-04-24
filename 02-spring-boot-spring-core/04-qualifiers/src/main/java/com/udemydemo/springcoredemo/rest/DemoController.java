package com.udemydemo.springcoredemo.rest;

import com.udemydemo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("spearCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }


//    @Autowired
//    public void se tCoach(Coach theCoach) {
//        this.myCoach = theCoach;
//    }
//
    /*
     @Autowired
    public void doSomething(Coach coach) {
        this.myCoach = coach;
    }
    */

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
