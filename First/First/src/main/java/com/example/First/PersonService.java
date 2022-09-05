package com.example.First;

import com.example.First.Model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    public Person getPerson(Long PersonId) {
        Person p = new Person("yash", "Goyal");

        return p;
    }


}
