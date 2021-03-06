package com.example.reactor.facturareactive.controller;

import com.example.reactor.facturareactive.model.Product;
import com.example.reactor.facturareactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<Product> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product p){
        return service.save(p);
    }
}
