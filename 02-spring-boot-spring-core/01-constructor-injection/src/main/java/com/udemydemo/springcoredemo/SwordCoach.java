package com.udemydemo.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class SwordCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice sword swings for 15 minutes!";
    }
}
