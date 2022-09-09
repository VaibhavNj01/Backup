package com.example.springDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeEntity {
    private Long id;
    private String firstName;
    private String lastName;


}
