package com.example.Facturacion.infrastructure.controller;

import java.util.List;

import com.example.Facturacion.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.application.ProductApplication;
import com.example.Facturacion.infrastructure.rest.ProductRest;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
	private ProductApplication app;

	@Autowired
	public ProductController(ProductService productService) {
		this.app = new ProductApplication(productService);
	}

	@GetMapping
	public List<ProductRest> findAll(Pageable pageable)
	{
		return app.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public ProductRest findByCode(@PathVariable Integer id)
	{
		return app.findByCode(id);
	}
	
	@PostMapping
	public ProductRest save(@RequestBody ProductRest producto)
	{
		return app.save(producto);
	}
	
	@PutMapping("/{id}")
	public ProductRest update(@PathVariable Integer id, @RequestBody ProductRest producto)
	{
		return app.update(producto, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByCode(@PathVariable Integer id)
	{
		app.deleteByCode(id);
	}
}
