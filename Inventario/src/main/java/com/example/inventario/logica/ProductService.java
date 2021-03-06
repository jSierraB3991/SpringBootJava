package com.example.inventario.logica;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventario.model.Product;
import com.example.inventario.repositori.productoRepository;

@Service
public class ProductService implements IProductService 
{
	@Autowired
	private productoRepository repo;
	
	@Override
	public List<Product> GetAllProducts() 
	{
		return repo.findAll();
	}

	@Override
	public Product GetProduct(int id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public Product SaveProduct(Product product) 
	{
		return repo.save(product);
	}

}
