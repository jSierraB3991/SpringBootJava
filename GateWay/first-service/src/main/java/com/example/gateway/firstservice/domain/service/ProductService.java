package com.example.gateway.firstservice.domain.service;

import java.util.List;

import com.example.gateway.firstservice.domain.model.Product;
import com.example.gateway.firstservice.shared.domain.model.IdProduct;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(IdProduct id);
	
	Product saveProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteById(IdProduct id);
}
