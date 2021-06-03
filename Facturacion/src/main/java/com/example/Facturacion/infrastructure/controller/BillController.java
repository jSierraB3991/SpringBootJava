package com.example.Facturacion.infrastructure.controller;

import java.util.List;

import com.example.Facturacion.domain.service.BillService;
import com.example.Facturacion.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.application.BillApplication;
import com.example.Facturacion.infrastructure.rest.BillRest;

@RestController
@RequestMapping("/api/bill")
public class BillController 
{
	private BillApplication app;

	@Autowired
	public BillController(BillService service,
							 ProductService serviceProducto){
		this.app = new BillApplication(service, serviceProducto);
	}
	
	@GetMapping
	public List<BillRest> findAll()
	{
		return app.findAll();
	}
	
	@GetMapping("/{id}")
	public BillRest findByCode(@PathVariable String id)
	{
		return app.findByCode(id);
	}
	
	@PostMapping
	public BillRest save(@RequestBody BillRest factura)
	{
		return app.save(factura);
	}

	@DeleteMapping("/{id}")
	public void deleteByCode(@PathVariable String id)
	{
		app.deleteByCode(id);
	}
}

