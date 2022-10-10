package com.example.demo.service;

import com.example.demo.entity.PersonEntity;

import com.example.demo.model.Person;
import com.example.demo.model.PersonResponse;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {


    @Autowired
    private  PersonRepository personRepository;

    public PersonResponse createPerson( Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setCity(person.getCity());
        personEntity.setZipcode(person.getZipcode());
        PersonResponse personResponse = new PersonResponse();
        Long id = (long) (Math.random() * 20);
        personEntity.setId(id);
        personResponse.setId(personEntity.getId());
        personRepository.save(personEntity);
        return personResponse;
    }


}
