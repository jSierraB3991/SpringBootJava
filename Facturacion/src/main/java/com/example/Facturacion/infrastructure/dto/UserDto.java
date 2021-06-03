package com.example.Facturacion.infrastructure.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_app")
@NoArgsConstructor
public class UserDto implements Serializable
{
	private static final long serialVersionUID = -4184506604693002006L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "userApp", unique = true)
	private String userApp;
	
	private String password;
	
	public UserDto(Integer id, String userApp, String password) 
	{
		this.id = id;
		this.userApp = userApp;
		this.password = password;
	}
}
