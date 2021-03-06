package com.example.gateway.secondservice.infrastructure.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_db")
@Table(name = "user_db")
public class UserDto 
{
	@Id
	private UUID id;
	
	private String name;
	private String lastName;
	
	@CreationTimestamp
	@Column(name = "creation_date", nullable = false, updatable = false)
	private Date dateCreation;
}
