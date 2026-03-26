package com.delochi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class WrestlingCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Try a hard 5K!";
    }
}
