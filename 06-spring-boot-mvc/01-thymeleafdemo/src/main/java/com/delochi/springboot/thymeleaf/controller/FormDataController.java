package com.delochi.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormDataController {
//    show-form
    @GetMapping("/show-form")
    public String showForm() {
        return "helloworld-form";
    }

//    process-form

    @GetMapping("/process-form")
    public String processForm(@RequestParam String studentName, Model model) {
        model.addAttribute("name",studentName);
        return "helloworld-data";
    }
}
