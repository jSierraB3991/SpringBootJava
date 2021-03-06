package com.example.gateway.firstservice.infrastructure.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class ProductDto 
{
	@Id
	private UUID id;
	
	private String name;
	private Double price;
	
	@CreationTimestamp
	@Column(name = "creation_date", nullable = false, updatable = false)
	private Date creationDate;
}
