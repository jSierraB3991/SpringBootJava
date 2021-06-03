package com.example.Facturacion.infrastructure.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductDto implements Serializable
{
	private static final long serialVersionUID = 1534032055940200943L;
	

	@Id
	private int id;
	private String nombre;
	private Double valor;
}
