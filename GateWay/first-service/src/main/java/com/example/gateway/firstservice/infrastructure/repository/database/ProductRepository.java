package com.example.gateway.firstservice.infrastructure.repository.database;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gateway.firstservice.infrastructure.dto.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, UUID> {

}
