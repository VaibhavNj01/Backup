package com.example.demo;

import com.trials.project.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student getStudent(Long studentId) {
        Student std = new Student("suchit", "khadtar");

        return std;

    }
}



