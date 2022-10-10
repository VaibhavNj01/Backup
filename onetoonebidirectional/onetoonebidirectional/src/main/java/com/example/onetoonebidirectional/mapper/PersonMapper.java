package com.example.onetoonebidirectional.mapper;

import com.example.onetoonebidirectional.entity.PersonEntity;
import com.example.onetoonebidirectional.model.Person;

public interface PersonMapper {
    PersonEntity personToEntity(Person person);
    Person entityToPerson(PersonEntity personEntity);

}
