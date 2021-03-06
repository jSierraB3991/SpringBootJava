package com.example.gateway.firstservice.infrastructure.mapper;

import java.util.UUID;

import com.example.gateway.firstservice.domain.model.Product;
import com.example.gateway.firstservice.infrastructure.dto.ProductDto;
import com.example.gateway.firstservice.infrastructure.rest.ProductRest;
import com.example.gateway.firstservice.shared.domain.model.CreationProduct;
import com.example.gateway.firstservice.shared.domain.model.IdProduct;
import com.example.gateway.firstservice.shared.domain.model.NameProduct;
import com.example.gateway.firstservice.shared.domain.model.PriceProduct;
import com.example.gateway.firstservice.shared.infrastructure.mapper.Mapper;

public class ProductMapper implements Mapper<ProductRest, ProductDto, Product> {

	public static final ProductMapper INSTANCE = new ProductMapper();
	
	@Override
	public ProductRest GetRest(Product domain) {
		return new ProductRest(domain.getId().getValue(), domain.getName().getValue(), 
				domain.getPrice().getValue(), domain.getDateCreation().getValue());
	}

	@Override
	public ProductDto GetDto(Product domain) {
		return new ProductDto(UUID.fromString(domain.getId().getValue()), domain.getName().getValue(), 
							  domain.getPrice().getValue(), domain.getDateCreation().getValue());
	}

	@Override
	public Product GetDomainByRest(ProductRest rest) {
		return Product.of(new IdProduct(rest.getId()), new NameProduct(rest.getName()),
						 new PriceProduct(rest.getPrice()), new CreationProduct(rest.getCreationDate()));
	}

	@Override
	public Product GetDomainByDto(ProductDto dto) {
		return Product.of(new IdProduct(dto.getId().toString()), new NameProduct(dto.getName()),
				 new PriceProduct(dto.getPrice()), new CreationProduct(dto.getCreationDate()));
	}

}
