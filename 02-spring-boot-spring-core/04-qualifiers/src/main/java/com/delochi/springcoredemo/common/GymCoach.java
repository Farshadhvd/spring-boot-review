package com.delochi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Do a warmup routine!";
    }
}
