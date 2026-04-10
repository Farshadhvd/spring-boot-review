package com.delochi.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String helloThyme(Model model) {
        model.addAttribute("theDate", LocalDateTime.now());
        return "helloPage";
    }
}
