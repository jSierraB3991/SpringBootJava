package com.github.jsierrab3991.keycloack.demoservice.service;

import com.github.jsierrab3991.keycloack.demoservice.dto.ProductDto;
import com.github.jsierrab3991.keycloack.demoservice.model.Product;
import com.github.jsierrab3991.keycloack.demoservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<ProductDto> findAll() {
        return repository.findAll()
                .stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProductDto save(ProductDto p){
        var pr = repository.save(toDomain(p));
        return toDto(pr);
    }

    public ProductDto update(Long productId, ProductDto p) {
        repository.findById(productId).orElseThrow();
        var pr = toDomain(p);
        pr.setId(productId);
        return toDto(repository.save(pr));
    }

    public void delete(Long productId) {
        var p = repository.findById(productId).orElseThrow();
        repository.delete(p);
    }

    private ProductDto toDto(Product p) {
        return ProductDto.builder()
                .id(p.getId())
                .stock(p.getStock())
                .name(p.getName())
                .price(p.getPrice())
                .build();
    }

    private Product toDomain(ProductDto p) {
        return Product.builder()
                .id(p.getId())
                .stock(p.getStock())
                .name(p.getName())
                .price(p.getPrice())
                .build();
    }
}
