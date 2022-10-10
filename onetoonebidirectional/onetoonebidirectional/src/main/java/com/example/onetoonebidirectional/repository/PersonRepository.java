package com.example.onetoonebidirectional.repository;

import com.example.onetoonebidirectional.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
