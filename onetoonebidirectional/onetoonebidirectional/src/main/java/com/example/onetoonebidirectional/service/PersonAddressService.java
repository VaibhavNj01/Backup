package com.example.onetoonebidirectional.service;

import com.example.onetoonebidirectional.entity.AddressEntity;
import com.example.onetoonebidirectional.entity.PersonEntity;
import com.example.onetoonebidirectional.mapper.AddressMapper;
import com.example.onetoonebidirectional.mapper.PersonMapper;
import com.example.onetoonebidirectional.model.Person;
import com.example.onetoonebidirectional.model.PersonResponse;
import com.example.onetoonebidirectional.repository.AddressRepository;
import com.example.onetoonebidirectional.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonAddressService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private final PersonMapper personMapper;
    @Autowired
    private final AddressMapper addressMapper;

    public PersonAddressService(PersonRepository personRepository, AddressRepository addressRepository, PersonMapper personMapper, AddressMapper addressMapper) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.personMapper = personMapper;
        this.addressMapper = addressMapper;
    }

    public PersonResponse createPerson(Person person) {
//        PersonResponse personResponse = new PersonResponse();
//
//        AddressEntity addressEntity = new AddressEntity();
//        addressEntity.setAddress1(person.getAddress().getAddress1());
//        addressEntity.setAddress2(person.getAddress().getAddress2());
//        addressEntity.setCity(person.getAddress().getCity());
//        addressEntity.setState(person.getAddress().getState());
//        addressEntity.setZipCode(person.getAddress().getZipcode());
//
//        PersonEntity personEntity = new PersonEntity();
//        personEntity.setFirstName(person.getFirstName());
//        personEntity.setLastName(person.getLastName());
//        personEntity.setAddress(addressEntity);
//        personRepository.save(personEntity);
//        personResponse.setId(personEntity.getId());
//        log.info("New record has been created");
//        return personResponse;
        PersonEntity personEntity = personMapper.personToEntity(person);

        AddressEntity addressEntity = addressMapper.addressToEntity(person.getAddress());
        personEntity.setAddress(addressEntity);
        addressEntity.setPerson(personEntity);
//        personEntity.getAddress().setPerson(personEntity);
        personRepository.save(personEntity);
//        addressRepository.save(addressEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());

        log.info("user name{}{} ", personEntity.getFirstName(), personEntity.getLastName() + " created successful");
        return personResponse;

    }

//    public Person getPerson(Long id) {
//        Person person = new Person();
//        PersonEntity personEntity = personRepository.findById(id).orElse(null);
//        if (personEntity != null) {
//            person = personMapper.entityToPerson(personEntity);
//        } else {
//            log.info("no such record found");
//        }
//        log.info("return person entity " + id + "this is");
//        return person;
//    }
//
//    public void deletePerson(Long id) {
//        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
//        if (personEntityOptional.isPresent()) {
//            personRepository.deleteById(id);
//        } else {
//            log.info("person id " + id + " not found");
//        }
//    }
//
//    public Person updatePerson(Long id, Person person) {
//        PersonEntity personEntity = new PersonEntity();
//        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
//        if (optionalPersonEntity.isPresent()) {
//            personEntity.setFirstName(person.getFirstName());
//            personEntity.setLastName(person.getLastName());
//            personMapper.personToEntity(person);
//            personRepository.save(personEntity);
//            log.info("Updated");
//        } else {
//            log.info("Person id " + id + "Not found");
//        }
//        return person;
//    }
}
