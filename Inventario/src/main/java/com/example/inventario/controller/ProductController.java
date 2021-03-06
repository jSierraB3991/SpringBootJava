package com.example.inventario.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.inventario.logica.IProductService;
import com.example.inventario.model.Product;
import com.example.inventario.model.Response;

@RestController
@RequestMapping("/api/product")
public class ProductController 
{
	@Autowired
	private IProductService service;
	
	@RequestMapping(method = RequestMethod.GET,  value = "/list")
	public List<Product> GetListProduct()
	{
		return this.service.GetAllProducts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Response<Product> GetProduct(@PathVariable String id)
	{
		try {
			Product p = this.service.GetProduct(Integer.parseInt(id));
			return new Response<Product>(true, "", p);
		}
		catch(Exception ex) {
			return new Response<Product>(false, ex.getMessage(), null);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Response<Product> AddProduct(@Valid @RequestBody Product product) 
	{
		try {
			Product p = service.SaveProduct(product);
			return new Response<Product>(true, "", p);
		}catch(Exception ex){
			return new Response<Product>(false, ex.getMessage(), null);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/edit")
	public Response<Product> UpdateProduct(@Valid @RequestBody Product product)
	{
		try { 
			Product p = service.SaveProduct(product);
			return new Response<Product>(true, "", p);
		}catch(Exception ex){
			return new Response<Product>(false, ex.getMessage(), null);
		}
	}
}
