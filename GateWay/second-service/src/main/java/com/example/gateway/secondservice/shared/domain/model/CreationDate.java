package com.example.gateway.secondservice.shared.domain.model;

import java.util.Date;

public class CreationDate 
{
	private final Date value;
	
	public CreationDate(Date creationDate) {
		this.value = creationDate;
	}

	public Date getValue() {
		return value;
	}
}
