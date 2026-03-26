package com.delochi.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SoccerCoach implements Coach{
    public SoccerCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Start practicing 5 penalty kicks in a row for each player.";
    }
}
