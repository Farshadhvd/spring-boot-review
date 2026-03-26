package com.delochi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Start practicing 5 penalty kicks in a row for each player.";
    }
}
