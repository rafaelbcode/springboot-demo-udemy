package com.udemydemo.springcoredemo.common;

public class ShieldCoach implements Coach {

    public ShieldCoach() {
        System.out.println("In Constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice shield defense for 15 minutes";
    }
}
