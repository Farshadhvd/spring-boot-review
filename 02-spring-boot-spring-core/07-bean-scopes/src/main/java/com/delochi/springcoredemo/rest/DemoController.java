package com.delochi.springcoredemo.rest;

import com.delochi.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class DemoController {

    private Coach coach;

    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("soccerCoach") Coach coach, @Qualifier("soccerCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }


//    Checking if the 2 fields are the same due to their scopes or not
    @GetMapping(value =  "/checkscopes", produces = "text/plain")
    public String check2beans() {

        return "coach field is referring to: " + coach.toString() +
                "\nanother coach field is referring to: " + anotherCoach.toString() +
                "\nSo " + (coach == anotherCoach) +"!";
    }
}
