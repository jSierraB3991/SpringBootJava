package com.github.jsierrab3991.keycloack.demoservice.repository;

import com.github.jsierrab3991.keycloack.demoservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
