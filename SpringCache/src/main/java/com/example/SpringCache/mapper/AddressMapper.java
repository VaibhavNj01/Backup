package com.example.SpringCache.mapper;

import com.example.SpringCache.entity.AddressEntity;
import com.example.SpringCache.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressEntity addressToAddressEntity(Address address);
    Address addressEntityToAddress(AddressEntity addressEntity);
}
