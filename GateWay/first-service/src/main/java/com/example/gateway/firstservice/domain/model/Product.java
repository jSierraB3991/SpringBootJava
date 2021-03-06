package com.example.gateway.firstservice.domain.model;

import java.util.Optional;
import java.util.UUID;

import com.example.gateway.firstservice.shared.domain.model.CreationProduct;
import com.example.gateway.firstservice.shared.domain.model.IdProduct;
import com.example.gateway.firstservice.shared.domain.model.PriceProduct;
import com.example.gateway.firstservice.shared.domain.model.NameProduct;

public class Product {

	private final IdProduct id;
	private final NameProduct name;
	private final PriceProduct price;
	private final CreationProduct dateCreation;
	
	private Product(IdProduct id, NameProduct name, PriceProduct price, CreationProduct dateCreation) {
		this.id = Optional.ofNullable(id.getValue()).isPresent() ? id : new IdProduct( UUID.randomUUID().toString());
		this.name = name;
		this.price = price;
		this.dateCreation = dateCreation;
	}
	
	public static Product of(IdProduct id, NameProduct name, PriceProduct price, CreationProduct date) 
	{
		return new Product(id, name, price, date);
	}

	public IdProduct getId() {
		return id;
	}

	public NameProduct getName() {
		return name;
	}

	public CreationProduct getDateCreation() {
		return dateCreation;
	}

	public PriceProduct getPrice() {
		return price;
	}
}
