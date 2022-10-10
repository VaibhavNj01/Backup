package com.example.onetoonebidirectional.mapper;

import com.example.onetoonebidirectional.entity.AddressEntity;
import com.example.onetoonebidirectional.model.Address;

public interface AddressMapper {
    AddressEntity addressToEntity(Address address);
    Address addressEntityToAddress(AddressEntity addressEntity);

}
