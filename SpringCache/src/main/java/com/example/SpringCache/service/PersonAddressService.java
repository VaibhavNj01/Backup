package com.example.SpringCache.service;

import com.example.SpringCache.entity.AddressEntity;
import com.example.SpringCache.entity.PersonEntity;
import com.example.SpringCache.mapper.AddressMapper;
import com.example.SpringCache.mapper.PersonMapper;
import com.example.SpringCache.model.Address;
import com.example.SpringCache.model.Person;
import com.example.SpringCache.model.PersonResponse;
import com.example.SpringCache.repository.AddressRepository;
import com.example.SpringCache.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
        AddressEntity addressEntity = addressMapper.addressToAddressEntity(person.getAddress());

        PersonEntity personEntity;
        personEntity = personMapper.personToEntity(person);
        personEntity.setAddressEntity(addressEntity);
        personRepository.save(personEntity);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        log.info("user name{}{} ", personEntity.getFirstName(), personEntity.getLastName() + " created successful");
        return personResponse;
    }

    @Cacheable(cacheNames = "person", key = "#id")
    public Person getPerson(Long id) {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        Person person = new Person();
        Address address = new Address();
        if (optionalPersonEntity.isPresent()) {
            AddressEntity addressEntity = optionalPersonEntity.get().getAddressEntity();
            PersonEntity personEntity = optionalPersonEntity.get();
            person = personMapper.entityToPerson(personEntity);
            address = addressMapper.addressEntityToAddress(addressEntity);
            person.setAddress(address);
            log.info("User name {} {} ", person.getFirstName(), person.getLastName() + " retrieved");
        }
        return person;
    }

    @CacheEvict(cacheNames = "person", key = "#id")
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
        log.info("person id {} ", id + " deleted successfully");
    }


    @CachePut(cacheNames = "person", key = "#id")
    public Person updatePerson(Long id, Person person) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isPresent()) {
            PersonEntity personEntity = personEntityOptional.get();
            AddressEntity addressEntity = personEntity.getAddressEntity();
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());

            addressEntity.setAddressOne(person.getAddress().getAddressOne());
            addressEntity.setAddressTwo(person.getAddress().getAddressTwo());
            addressEntity.setCity(person.getAddress().getCity());
            addressEntity.setState(person.getAddress().getState());
            addressEntity.setZipCode(person.getAddress().getZipCode());

            personEntity.setAddressEntity(addressEntity);
            personRepository.save(personEntityOptional.get());

            log.info("person with id {} ", id + " updated successfully");

        }

        return person;
    }
}
