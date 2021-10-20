package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomersEntity, String> {
}