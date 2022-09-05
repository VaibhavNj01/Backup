package com.example.First.Controller;

import com.example.First.Model.Person;
import com.example.First.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Person> getPerson(@PathVariable Long personId) {
        //Person p = new Person("vaibhav","jadhav");
        Person p =  personService.getPerson(1l);

        return new ResponseEntity<>(p, HttpStatus.OK);

    }


}
