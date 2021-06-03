package com.example.Facturacion.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ItemRest 
{
	private String codigo;
	private int cantidad;
	private ProductRest producto;
	private Double valor;
}
