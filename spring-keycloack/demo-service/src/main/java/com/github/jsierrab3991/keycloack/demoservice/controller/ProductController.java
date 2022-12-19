package com.github.jsierrab3991.keycloack.demoservice.controller;

import com.github.jsierrab3991.keycloack.demoservice.dto.ProductDto;
import com.github.jsierrab3991.keycloack.demoservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto p) {
        return service.save(p);
    }

    @PutMapping("/{id_product}")
    public ProductDto update(@PathVariable("id_product") Long productId, @RequestBody ProductDto p) {
        return service.update(productId, p);
    }

    @DeleteMapping("/{id_product}")
    public ResponseEntity<Void> delete(@PathVariable("id_product") Long productId) {
        service.delete(productId);
        return ResponseEntity.ok().build();
    }
}
