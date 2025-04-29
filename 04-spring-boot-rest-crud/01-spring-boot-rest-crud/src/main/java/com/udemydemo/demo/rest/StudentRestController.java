package com.udemydemo.demo.rest;

import com.udemydemo.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //called once after bean was constructed
    @PostConstruct
    public void loadData() {
        this.theStudents = new ArrayList<>();
        this.theStudents.add(new Student("Poornima", "Patel"));
        this.theStudents.add(new Student("Mario", "Rossi"));
        this.theStudents.add(new Student("Mary", "Smith"));
    }

    //GET list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //GET student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        return theStudents.get(studentId);
    }
}
