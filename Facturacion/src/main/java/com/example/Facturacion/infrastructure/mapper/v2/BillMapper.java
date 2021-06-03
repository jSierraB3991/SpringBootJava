package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.Bill;
import com.example.Facturacion.infrastructure.dto.BillDto;
import com.example.Facturacion.infrastructure.rest.BillRest;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.NameBill;
import com.example.Facturacion.shared.domain.ValueBill;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class BillMapper implements GenericMapper<BillRest, Bill, BillDto>
{
	public static final BillMapper INSTANCE = new BillMapper();

	@Override
	public BillRest getRest(Bill domain) 
	{
		return new BillRest(domain.getCodigo().getValue(), domain.getNombre().getValue(), 
				domain.getValor().getValue(), ItemMapper.INSTANCE.getListRest(domain.getItems()));
	}

	@Override
	public BillDto getDto(Bill domain) 
	{
		return new BillDto(domain.getCodigo().getValue(), domain.getNombre().getValue(), 
				domain.getValor().getValue(), ItemMapper.INSTANCE.getListDto(domain.getItems()));
	}

	@Override
	public Bill getByRest(BillRest rest) 
	{
		return Bill.of(new Codigo(rest.getCodigo()), new NameBill(rest.getNombre()),
				new ValueBill(rest.getValor()), ItemMapper.INSTANCE.getListByRest(rest.getItems()));
	}

	@Override
	public Bill getByDto(BillDto dto) 
	{
		return Bill.of(new Codigo(dto.getCodigo()), new NameBill(dto.getNombre()),
				new ValueBill(dto.getValor()), ItemMapper.INSTANCE.getListByDto(dto.getItem()));
	}

}
