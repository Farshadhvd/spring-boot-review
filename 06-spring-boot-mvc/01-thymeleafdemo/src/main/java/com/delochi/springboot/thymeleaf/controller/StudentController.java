package com.delochi.springboot.thymeleaf.controller;

import com.delochi.springboot.thymeleaf.model.Country;
import com.delochi.springboot.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${student.favourite.language.list}")
    private List<String> favouriteLanguages;

    @Value("${student.favourite.os.list}")
    private List<String> favouriteSystems;

    @GetMapping("/show-student-form")
    public String showStudentForm(Model model) {
        Student student = new Student();

        model.addAttribute("student",student);
        model.addAttribute("countries", Country.values());
        model.addAttribute("favouriteLanguages", favouriteLanguages);
        model.addAttribute("favouriteSystems", favouriteSystems);
        return "student-form";
    }
    @PostMapping("/process-student")
    public String processStudentForm(@ModelAttribute(name = "student") Student student) {
        System.out.println("The student is received: " + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
}
