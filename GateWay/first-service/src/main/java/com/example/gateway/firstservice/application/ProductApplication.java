package com.example.gateway.firstservice.application;

import java.util.List;

import com.example.gateway.firstservice.domain.model.Product;
import com.example.gateway.firstservice.domain.service.ProductService;
import com.example.gateway.firstservice.shared.domain.model.IdProduct;

public class ProductApplication {

	private final ProductService service;
	
	public ProductApplication(ProductService service) {
		this.service = service;
	}
	
	public List<Product> findAll()
	{
		return this.service.findAll();
	}
	
	public Product findById(IdProduct id) 
	{
		return this.service.findById(id);
	}
	
	public Product saveProduct(Product product) 
	{
		return this.service.saveProduct(product);
	}
	
	public Product updateProduct(Product product) 
	{
		return this.service.updateProduct(product);
	}
	
	public void deleteById(IdProduct id) 
	{
		this.service.deleteById(id);
	}
}
