package com.example.onetoone.model;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private Address address;

}
