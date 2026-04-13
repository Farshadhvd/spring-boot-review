package com.delochi.springboot.thymeleaf.controller;

import com.delochi.springboot.thymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/show-student-form")
    public String showStudentForm(Model model) {
        Student student = new Student();

        model.addAttribute("student",student);
        return "student-form";
    }
    @PostMapping("/process-student")
    public String showStudentForm(@ModelAttribute(name = "student") Student student) {
        System.out.println("The student is received: " + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
}
