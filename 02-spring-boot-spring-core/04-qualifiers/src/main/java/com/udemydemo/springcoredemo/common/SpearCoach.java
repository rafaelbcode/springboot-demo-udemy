package com.udemydemo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SpearCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Do 50 spear stabs";
    }
}
