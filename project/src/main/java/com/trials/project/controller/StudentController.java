package com.trials.project.controller;


import com.trials.project.model.Student;
import com.example.demo.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping(path="/students/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
      //  Student std = new Student("Vaibhav","jadhav");

        Student std = studentService.getStudent(1l);

        return new ResponseEntity<>(std, HttpStatus.OK);

    }


}
