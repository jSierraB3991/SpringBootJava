package com.example.reactor.facturareactive.repository.repository;

import com.example.reactor.facturareactive.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, Serializable> {
}
