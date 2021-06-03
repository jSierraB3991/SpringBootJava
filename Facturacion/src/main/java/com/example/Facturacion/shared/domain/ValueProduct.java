package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class ValueProduct 
{
	private final Double value;

	public ValueProduct(Double valor) {
	this.value = valor;
	if(valor<1)
		Util.throwException("exception.valueProductError", Double.toString(valor));
	if(valor>9999999.0)
		Util.throwException("exception.valueProductError", Double.toString(valor));
	}


	public Double getValue() {
		return value;
	}
}
