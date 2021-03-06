package com.example.gateway.firstservice.shared.domain.model;

import java.util.Date;

public class CreationProduct {

	private final Date value;
	
	public CreationProduct(Date date) {
		this.value = date;
	}

	public Date getValue() {
		return value;
	}
}
