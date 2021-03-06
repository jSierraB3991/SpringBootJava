package com.example.reactor.facturareactive.service;

import com.example.reactor.facturareactive.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService
{
    Flux<Product> findAll();

    Mono<Product> save(Product p);
}
