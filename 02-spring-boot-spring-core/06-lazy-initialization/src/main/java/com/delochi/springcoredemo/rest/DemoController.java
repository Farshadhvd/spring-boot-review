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


    @Autowired
    public DemoController(@Qualifier("soccerCoach") Coach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }


//    @Autowired
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
