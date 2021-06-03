package com.example.Facturacion.domain.service;

import java.util.List;

import com.example.Facturacion.domain.modeldomain.Bill;
import com.example.Facturacion.shared.domain.Codigo;

public interface BillService
{
	List<Bill> findAll();
	
	Bill findByCode(Codigo codigo);
	
	Bill save(Bill factura);

	void deleteByCode(Codigo codigo);
}
