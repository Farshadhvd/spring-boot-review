package com.delochi.springbootrestcrud.rest;

import com.delochi.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Farshad", "Hasanvand"));
        students.add(new Student("Jasem", "Zergani"));
        students.add(new Student("Abood", "BaniKaab"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getAllStudents(@PathVariable int studentId){

        if (studentId >= students.size() || studentId<0) {
            throw new StudentNotFoundException("There is no student available with index: " + studentId);
        }
        return students.get(studentId);
    }

}
