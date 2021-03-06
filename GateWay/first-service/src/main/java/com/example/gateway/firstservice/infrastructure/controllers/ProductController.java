package com.example.gateway.firstservice.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gateway.firstservice.application.ProductApplication;
import com.example.gateway.firstservice.domain.service.ProductService;
import com.example.gateway.firstservice.infrastructure.mapper.ProductMapper;
import com.example.gateway.firstservice.infrastructure.rest.ProductRest;
import com.example.gateway.firstservice.shared.domain.model.IdProduct;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController 
{
	private final ProductApplication app;
	
	public ProductController(@Autowired ProductService service) {
		this.app = new ProductApplication(service);
	}
	
	@GetMapping
	public List<ProductRest> findAll()
	{
		return ProductMapper.INSTANCE.GetRest(app.findAll());
	}
	
	@GetMapping("/{id}")
	public ProductRest findById(@PathVariable String id) 
	{
		return ProductMapper.INSTANCE.GetRest(app.findById(new IdProduct(id)));
	}
	
	@PostMapping
	public ProductRest save(@RequestBody ProductRest product)
	{
		return ProductMapper.INSTANCE.GetRest(app.saveProduct(ProductMapper.INSTANCE.GetDomainByRest(product)));
	}
	
	@PutMapping
	public void update(@RequestBody ProductRest product)
	{
		app.updateProduct(ProductMapper.INSTANCE.GetDomainByRest(product));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) 
	{
		app.deleteById(new IdProduct(id));
	}
}
