package com.example.onetoonespring.mapper;

import com.example.onetoonespring.entity.AddressEntity;
import com.example.onetoonespring.entity.PersonEntity;
import com.example.onetoonespring.model.Address;
import com.example.onetoonespring.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface PersonAddressMapper {
    PersonAddressMapper INSTANCE= Mappers.getMapper(PersonAddressMapper.class);

    PersonEntity personToEntity(Person person);
    AddressEntity addressToEntity(Address address);

    Person entityToPerson(PersonEntity personEntity);
}
