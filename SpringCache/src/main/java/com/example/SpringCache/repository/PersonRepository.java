package com.example.SpringCache.repository;

import com.example.SpringCache.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<PersonEntity,Long> {
}
