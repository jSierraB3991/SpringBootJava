package com.example.gateway.firstservice.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gateway.firstservice.domain.model.Product;
import com.example.gateway.firstservice.domain.service.ProductService;
import com.example.gateway.firstservice.infrastructure.dto.ProductDto;
import com.example.gateway.firstservice.infrastructure.mapper.ProductMapper;
import com.example.gateway.firstservice.infrastructure.repository.database.ProductRepository;
import com.example.gateway.firstservice.shared.domain.model.IdProduct;
import com.example.gateway.firstservice.shared.infrastructure.exception.RecordNotFoundException;

@Service
public class ProductAdapter implements ProductService {

	@Autowired private ProductRepository repository;
	
	@Override
	public List<Product> findAll() 
	{
		return ProductMapper.INSTANCE.GetDomainByDto(this.repository.findAll());
	}

	@Override
	public Product findById(IdProduct id) {
		return ProductMapper.INSTANCE.GetDomainByDto(this.repository.findById(UUID.fromString(id.getValue()))
									.orElseThrow(() -> new RecordNotFoundException("INVALID PRODUCT", id.getValue())));
	}

	@Override
	public Product saveProduct(Product product) 
	{
		Optional<ProductDto> productoDto = repository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(product.getName().getValue())).findFirst();
		
		if(productoDto.isPresent() && !productoDto.get().getId().toString().equalsIgnoreCase(product.getId().getValue()))
			throw new RuntimeException("THIS NAME PRODUCT HE IS REGISTER");
		
		return ProductMapper.INSTANCE.GetDomainByDto(
				this.repository.save(ProductMapper.INSTANCE.GetDto(product)));
	}

	@Override
	public Product updateProduct(Product product) 
	{
		this.findById(product.getId());
		return this.saveProduct(product);
	}

	@Override
	public void deleteById(IdProduct id) {
		this.findById(id);
		this.repository.deleteById(UUID.fromString(id.getValue()));
	}
}
