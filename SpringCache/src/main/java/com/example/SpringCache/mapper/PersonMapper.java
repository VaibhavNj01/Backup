package com.example.SpringCache.mapper;

import com.example.SpringCache.entity.PersonEntity;
import com.example.SpringCache.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PersonMapper {
    PersonEntity personToEntity(Person person);
    Person entityToPerson(PersonEntity personEntity);

}
