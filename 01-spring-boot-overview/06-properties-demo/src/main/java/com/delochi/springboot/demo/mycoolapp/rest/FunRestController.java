package com.delochi.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

//    Defining property names to test injection
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World! Delochi is back... :)";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run HIIT and Fat Burn for 20 minutes a week dude!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Remember! You can always save the day :)";
    }

    //Create an endpoint to test the property injection working fine.
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
}
