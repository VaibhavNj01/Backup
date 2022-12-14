package com.crossasyst.firstspringproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeEntity {
    private Long id;
    private String firstName;
    private String lastName;
}
