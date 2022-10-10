package com.example.onetoonebidirectional.model;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;

    private Address address;
}
