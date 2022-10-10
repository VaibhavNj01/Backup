package com.example.cartanditem.repository;

import com.example.cartanditem.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
