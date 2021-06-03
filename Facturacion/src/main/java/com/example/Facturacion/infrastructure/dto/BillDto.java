package com.example.Facturacion.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@Getter
@Setter
public class BillDto extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	private String nombre;

	private Double valor;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDto> item;
	
	public BillDto(String codigo, String nombre, Double valor, List<ItemDto> item) {
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.valor = valor;
		this.item = item;
	}
}
