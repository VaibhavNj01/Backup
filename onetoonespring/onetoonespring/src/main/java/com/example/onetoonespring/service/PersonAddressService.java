package com.example.onetoonespring.service;

import com.example.onetoonespring.entity.AddressEntity;
import com.example.onetoonespring.entity.PersonEntity;
import com.example.onetoonespring.mapper.PersonAddressMapper;
import com.example.onetoonespring.model.Person;
import com.example.onetoonespring.model.PersonResponse;
import com.example.onetoonespring.repository.AddressRepository;
import com.example.onetoonespring.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonAddressMapper personAddressMapper;

    public PersonResponse createPerson(Person person) {
        PersonResponse personResponse = new PersonResponse();

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipCode(person.getAddress().getZipcode());

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
        personResponse.setId(personEntity.getId());
        log.info("New record has been created");
        return personResponse;
    }

    public Person getPerson(Long id) {
        Person person = new Person();
        PersonEntity personEntity = personRepository.findById(id).orElse(null);
        if (personEntity != null) {
            person = personAddressMapper.entityToPerson(personEntity);
        } else {
            log.info("no such record found");
        }
        log.info("return person entity "+id+"this is");
        return person;
    }

    public void deletePerson(Long id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isPresent()) {
            personRepository.deleteById(id);
        } else {
            log.info("person id " + id + " not found");
        }
    }

    public Person updatePerson(Long id, Person person) {
        PersonEntity personEntity = new PersonEntity();
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        if (optionalPersonEntity.isPresent()) {
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());
            personAddressMapper.personToEntity(person);
            personRepository.save(personEntity);
            log.info("Updated");
        } else {
            log.info("Person id " + id + "Not found");
        }
        return person;
    }


}
