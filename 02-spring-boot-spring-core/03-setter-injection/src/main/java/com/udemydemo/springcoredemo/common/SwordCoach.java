package com.udemydemo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SwordCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice sword swings for 15 minutes >:)";
    }
}
