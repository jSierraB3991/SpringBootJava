package com.example.Facturacion.infrastructure.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@NoArgsConstructor
@Getter
@Setter
public class ItemDto extends BaseEntity 
{
	private static final long serialVersionUID = 1L;

	private int cantidad;
	
	@OneToOne(targetEntity = ProductDto.class)
	private ProductDto producto;
	
	private Double valor;
	
	public ItemDto(String codigo, int cantidad, Double valor, ProductDto producto) {
		this.setCodigo(codigo);
		this.cantidad = cantidad;
		this.valor = valor;
		this.producto = producto;
	}
}
