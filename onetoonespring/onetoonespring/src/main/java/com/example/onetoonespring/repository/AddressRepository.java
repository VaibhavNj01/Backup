package com.example.onetoonespring.repository;

import com.example.onetoonespring.entity.AddressEntity;
import com.example.onetoonespring.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
