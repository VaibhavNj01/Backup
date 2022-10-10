package com.example.onetoonebidirectional.controller;

import com.example.onetoonebidirectional.model.Person;
import com.example.onetoonebidirectional.model.PersonResponse;
import com.example.onetoonebidirectional.service.PersonAddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@Log4j2
public class PersonAddressController {
    @Autowired
    private  PersonAddressService personAddressService;

  

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personAddressService.createPerson(person);
        log.info("person created sucessfully");
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

//    @GetMapping(path = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
//        Person person = personAddressService.getPerson(id);
//        return new ResponseEntity<>(person, HttpStatus.OK);
//    }
//
//    @DeleteMapping(path = "/persons/{id}")
//    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
//        personAddressService.deletePerson(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping(path = "/persons/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id) {
//        person = personAddressService.updatePerson(id, person);
//        return new ResponseEntity<>(person, HttpStatus.OK);
//    }
}
