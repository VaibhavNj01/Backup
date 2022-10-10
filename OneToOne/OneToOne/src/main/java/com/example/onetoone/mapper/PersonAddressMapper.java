package com.example.onetoone.mapper;

import com.example.onetoone.entity.AddressEntity;
import com.example.onetoone.entity.PersonEntity;
import com.example.onetoone.model.Address;
import com.example.onetoone.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonAddressMapper {
    PersonAddressMapper INSTANCE = Mappers.getMapper(PersonAddressMapper.class);

    PersonEntity personToEntity(Person person);

    AddressEntity personToEntity(Address address);

    Person entityToPerson(PersonEntity personEntity);
}
