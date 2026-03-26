package com.delochi.springcoredemo.config;

import com.delochi.springcoredemo.common.Coach;
import com.delochi.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Bean(value = "swimCoach")
    public Coach swimCoach() {
        System.out.println("Bean annotation for swimCoach works!");
        return new SwimCoach();
    }
}
