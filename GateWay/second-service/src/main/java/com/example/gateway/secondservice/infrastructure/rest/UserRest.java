package com.example.gateway.secondservice.infrastructure.rest;

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
public class UserRest 
{
	private String id;
	private String name;
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
}