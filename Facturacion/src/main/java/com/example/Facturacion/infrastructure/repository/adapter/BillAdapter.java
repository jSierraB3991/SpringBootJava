package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;

import com.example.Facturacion.domain.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.Bill;
import com.example.Facturacion.infrastructure.dto.BillDto;
import com.example.Facturacion.infrastructure.mapper.v2.BillMapper;
import com.example.Facturacion.infrastructure.repository.database.BillRepository;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.infrastructure.Util.Util;

@Service
public class BillAdapter implements BillService
{
	private BillRepository repo;

	@Autowired
	public BillAdapter(BillRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Bill> findAll() {
		return BillMapper.INSTANCE.getListByDto(repo.findAll());
	}

	@Override
	public Bill findByCode(Codigo codigo)
	{
		Optional<BillDto> bill = repo.findById(codigo.getValue());
		if(!bill.isPresent()) {
			Util.notFoundException("exception.billInvalid", codigo.getValue());
			return null;
		}
		return BillMapper.INSTANCE.getByDto(bill.get());
	}

	@Override
	public Bill save(Bill factura)
	{
		return BillMapper.INSTANCE.getByDto(repo.save(BillMapper.INSTANCE.getDto(factura)));
	}

	@Override
	public void deleteByCode(Codigo codigo)
	{
		this.findByCode(codigo);
		repo.deleteById(codigo.getValue());
	}

}
