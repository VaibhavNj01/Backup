package com.example.springjpademo.controller;

import com.example.springjpademo.entity.PersonEntity;
import com.example.springjpademo.model.Person;
import com.example.springjpademo.model.PersonResponse;
import com.example.springjpademo.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Log4j2
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.createPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Person> getPerson(@PathVariable Long personId) {
        Person person = personService.getPerson(personId);
        if (Objects.isNull(person)) {
            log.info("People id" + personId + "found");
            //log.info(people.getFirstName());
        } else {
            ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping(path = "/persons/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePeople(@PathVariable Long personId, @RequestBody Person person) {
        personService.updatePeople(personId, person);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "/persons/{personId}")
    public ResponseEntity<Person> deletePeople(@PathVariable Long peopleId) {
        personService.deletePeople(peopleId);
        return ResponseEntity.ok().build();
    }

}
