package com.example.gateway.firstservice.shared.domain.model;

public class PriceProduct {

	private final Double value;
	
	public PriceProduct(Double price) {
		this.value = price;
	}

	public Double getValue() {
		return value;
	}
}
