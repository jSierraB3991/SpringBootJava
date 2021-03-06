package com.example.reactor.facturareactive.repository.adapter;

import com.example.reactor.facturareactive.model.Product;
import com.example.reactor.facturareactive.repository.repository.ProductRepository;
import com.example.reactor.facturareactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductAdapter implements ProductService
{
    @Autowired
    private ProductRepository repository;

    @Override
    public Flux<Product> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Mono<Product> save(Product p)
    {
        return repository.save(p);
    }
}
