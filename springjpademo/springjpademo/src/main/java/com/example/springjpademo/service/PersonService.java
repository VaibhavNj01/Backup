package com.example.springjpademo.service;

import com.example.springjpademo.entity.PersonEntity;
import com.example.springjpademo.mapper.PersonMapper;
import com.example.springjpademo.model.Person;
import com.example.springjpademo.model.PersonResponse;
import com.example.springjpademo.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Optional;

@Log4j2
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;


    public PersonResponse createPerson(Person person) {
        PersonResponse personResponse = new PersonResponse();
        PersonEntity personEntity = new PersonEntity();
        // personEntity = PersonMapper.personTOEntity(person);
        Long id = (long) (Math.random() * 20);
        personEntity.setId(id);
        personRepository.save(personMapper.personTOEntity(person));
        personResponse.setId(personEntity.getId());
        personRepository.save(personEntity);
        return personResponse;
    }

    public Person getPerson(Long personId) {
        Person person = new Person();
        Optional<PersonEntity> personEntityOptional = personRepository.findById(personId);
        if (personEntityOptional.isPresent()) {
            person = personMapper.entityToPerson(personEntityOptional.get());
            personRepository.save(personEntityOptional.get());
        } else {
            log.info("person Id" + personId + "Not Found");
        }

        return person;
    }

    public PersonEntity updatePeople(Long personId, Person person) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personId);
        PersonEntity personEntity1 = personRepository.save(personMapper.personTOEntity(person));


//        if (personEntity.isPresent()) {
//            person = personMapper.personTOEntity(person).get();
//            personRepository.save(personEntityOptional.get());
//
//        } else {
//            log.info("People Id" + personId + "Not Found");
//        }

        return personEntity1;
    }

    public void deletePeople(Long peopleId) {
        personRepository.deleteById(peopleId);
    }

}
