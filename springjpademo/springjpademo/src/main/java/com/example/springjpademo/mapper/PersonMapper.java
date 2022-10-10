package com.example.springjpademo.mapper;

import com.example.springjpademo.entity.PersonEntity;
import com.example.springjpademo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
   // PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonEntity personTOEntity(Person person);

    Person entityToPerson(PersonEntity personEntity);
}
