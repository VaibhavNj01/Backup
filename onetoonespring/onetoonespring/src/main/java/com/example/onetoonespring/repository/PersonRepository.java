package com.example.onetoonespring.repository;

import com.example.onetoonespring.entity.PersonEntity;
import com.example.onetoonespring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
