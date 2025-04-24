package com.udemydemo.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SwordCoach implements Coach {

    public SwordCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    //init
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In postConstruct: " + this.getClass().getSimpleName());
    }

    //destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In preDestroy: " + this.getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice sword swings for 15 minutes >:)";
    }
}
