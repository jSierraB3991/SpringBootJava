package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.Product;
import com.example.Facturacion.infrastructure.dto.ProductDto;
import com.example.Facturacion.infrastructure.rest.ProductRest;
import com.example.Facturacion.shared.domain.Id;
import com.example.Facturacion.shared.domain.NameProduct;
import com.example.Facturacion.shared.domain.ValueProduct;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class ProductMapper implements GenericMapper<ProductRest, Product, ProductDto>
{
	public static final ProductMapper INSTANCE = new ProductMapper(); 

	@Override
	public ProductRest getRest(Product domain) 
	{
		return new ProductRest(domain.getId().getValue(), 
				domain.getNombre().getValue(), domain.getValor().getValue());
	}

	@Override
	public ProductDto getDto(Product domain) 
	{
		return new ProductDto(domain.getId().getValue(), 
				domain.getNombre().getValue(), domain.getValor().getValue());
	}

	@Override
	public Product getByRest(ProductRest rest) 
	{
		return Product.of(new Id(rest.getId()), 
				new NameProduct(rest.getNombre()), new ValueProduct(rest.getValor()));
	}

	@Override
	public Product getByDto(ProductDto dto) 
	{
		return Product.of(new Id(dto.getId()), 
				new NameProduct(dto.getNombre()), new ValueProduct(dto.getValor()));
	}

}
