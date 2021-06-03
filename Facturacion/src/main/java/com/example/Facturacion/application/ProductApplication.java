package com.example.Facturacion.application;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.Facturacion.domain.service.ProductService;
import com.example.Facturacion.infrastructure.rest.ProductRest;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.shared.domain.Id;

public class ProductApplication 
{
	private ProductService service;

	public ProductApplication(ProductService service) {
		this.service = service;
	}

	public List<ProductRest> findAll(Pageable pageable)
	{
		return ProductMapper.INSTANCE.getListRest(service.findAll(pageable));
	}
	
	public ProductRest findByCode(Integer codigo)
	{
		return ProductMapper.INSTANCE.getRest(service.findByCode(new Id(codigo)));
	}
	
	public ProductRest save(ProductRest product)
	{
		return ProductMapper.INSTANCE.getRest(service.save(ProductMapper.INSTANCE.getByRest(product)));
	}
	
	public ProductRest update(ProductRest product, Integer codigo)
	{
		product.setId(codigo);
		return ProductMapper.INSTANCE.getRest(service.update((ProductMapper.INSTANCE.getByRest(product))));
	}
	
	public void deleteByCode(Integer codigo)
	{
		service.deleteByCode(new Id(codigo));
	}
}
