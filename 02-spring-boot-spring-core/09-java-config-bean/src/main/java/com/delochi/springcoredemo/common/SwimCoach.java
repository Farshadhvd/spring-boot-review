package com.delochi.springcoredemo.common;

import jakarta.annotation.PostConstruct;

public class SwimCoach implements Coach{


    //I want to test if @PostConstruct is integrated with @Bean.

    @PostConstruct
    public void complyWithBeanAnnotation() {
        System.out.println("Yes, @PostConstruct and @Bean are related like @Component :)");
    }

    @Override
    public String getDailyWorkout() {
        return "Try swimming along the pool 4 times as a warmup :D";
    }
}
