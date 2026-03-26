package com.delochi.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{
    public SoccerCoach() {
//        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //init method
    @PostConstruct
    public void sayPresent() {
        System.out.println("Hey, I am " + getClass().getSimpleName() + "! Just created!");
    }


    //before destroy method
    @PreDestroy
    public void sayBye() {
        System.out.println(getClass().getSimpleName() + " just left the container!");
    }
    @Override
    public String getDailyWorkout() {
        return "Start practicing 5 penalty kicks in a row for each player.";
    }
}
