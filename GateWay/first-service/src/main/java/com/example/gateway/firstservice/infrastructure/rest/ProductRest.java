package com.example.gateway.firstservice.infrastructure.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRest 
{
	private String id;
	private String name;
	private Double price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;
}
