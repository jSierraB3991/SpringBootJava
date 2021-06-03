package com.example.Facturacion.application;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Facturacion.domain.service.BillService;
import com.example.Facturacion.domain.service.ProductService;
import com.example.Facturacion.infrastructure.rest.BillRest;
import com.example.Facturacion.infrastructure.rest.ItemRest;
import com.example.Facturacion.infrastructure.rest.ProductRest;
import com.example.Facturacion.infrastructure.mapper.v2.BillMapper;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.Id;

public class BillApplication 
{
	private BillService service;
	private ProductService serviceProducto;

	public BillApplication(BillService service,
							  ProductService serviceProducto) {
		this.service = service;
		this.serviceProducto = serviceProducto;
	}

	public List<BillRest> findAll()
	{
		return BillMapper.INSTANCE.getListRest(service.findAll());
	}
	
	public BillRest findByCode(String codigo)
	{
		return BillMapper.INSTANCE.getRest(service.findByCode(new Codigo(codigo)));
	}
	
	public BillRest save(BillRest factura)
	{
		factura.setCodigo(GetID.getId());
		List<ProductRest> productrestdto =  ProductMapper.INSTANCE.getListRest(serviceProducto.findByCodes(
				factura.getItems().stream()
								  .map(irdto -> new Id(irdto.getProducto().getId()))
								  .collect(Collectors.toList())
		));
		factura.getItems().stream().forEach(item -> {
			item.setCodigo(GetID.getId());
			item.setProducto(productrestdto.stream()
											.filter(pro -> pro.getId().equals(item.getProducto().getId()))
											.findFirst().get());
			item.setValor(item.getCantidad() * item.getProducto().getValor());
			
		});
		factura.setValor(factura.getItems().stream().mapToDouble(ItemRest::getValor).sum());
		return BillMapper.INSTANCE.getRest(service.save(BillMapper.INSTANCE.getByRest(factura)));
		
	}

	public void deleteByCode (String codigo)
	{
		service.deleteByCode(new Codigo(codigo));
	}
}
