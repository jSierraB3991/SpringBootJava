package com.example.Facturacion.infrastructure.repository.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.Facturacion.infrastructure.dto.ProductDto;

@Repository
public interface ProductRepository 
				extends JpaRepository<ProductDto, Integer>,
				 PagingAndSortingRepository<ProductDto, Integer>{
	
	public abstract Page<ProductDto> findAll(Pageable pageable);
	
}
