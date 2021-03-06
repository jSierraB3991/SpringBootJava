package com.example.inventario.logica;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.inventario.model.Product;

@Service
public interface IProductService 
{
	List<Product> GetAllProducts();
	
	Product GetProduct(int id);
	
	Product SaveProduct(Product product);
}
