package com.udemydemo.springcoredemo.config;

import com.udemydemo.springcoredemo.common.Coach;
import com.udemydemo.springcoredemo.common.ShieldCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainingConfig {

    @Bean("shield")
    public Coach shieldCoach(){
        return new ShieldCoach();
    }

}
