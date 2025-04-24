package com.udemydemo.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FormationCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in phalanx formation";
    }
}
