package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class ValueBill 
{
	private final Double value;

	public ValueBill(Double valor) {
	this.value = valor;
	if(valor<1)
		Util.throwException("exception.valueBillError", Double.toString(valor));
	if(valor>99999999999.0)
		Util.throwException("exception.valueBillError", Double.toString(valor));
	}


	public Double getValue() {
		return value;
	}
}
