package com.example.inventario.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.inventario.model.Product;

@Repository
public interface productoRepository extends JpaRepository<Product, Integer> {


}
