package com.udemydemo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BowCoach implements Coach  {
    @Override
    public String getDailyWorkout() {
        return "30 minutes of bow and arrow practice";
    }
}
