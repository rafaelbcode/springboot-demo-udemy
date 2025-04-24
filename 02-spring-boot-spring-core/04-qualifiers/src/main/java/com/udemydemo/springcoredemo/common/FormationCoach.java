package com.udemydemo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FormationCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in phalanx formation";
    }
}
