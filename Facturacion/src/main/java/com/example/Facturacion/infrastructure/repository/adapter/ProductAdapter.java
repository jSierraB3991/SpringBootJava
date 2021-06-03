package com.example.Facturacion.infrastructure.repository.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.Facturacion.domain.modeldomain.Product;
import com.example.Facturacion.domain.service.ProductService;
import com.example.Facturacion.domain.service.ReportService;
import com.example.Facturacion.infrastructure.dto.ProductDto;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import com.example.Facturacion.infrastructure.repository.database.ProductRepository;
import com.example.Facturacion.shared.domain.Id;
import com.example.Facturacion.shared.infrastructure.Util.Util;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductAdapter implements ProductService, ReportService
{
	private ProductRepository repo;

	@Autowired
	public ProductAdapter(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Product> findAll(Pageable pageable)
	{
		return ProductMapper.INSTANCE.getListByDto(repo.findAll(pageable).toList());
	}

	@Override
	public Product findByCode(Id codigo)
	{
		Optional<ProductDto> product = repo.findById(codigo.getValue());
		if(!product.isPresent()) {
			Util.notFoundException("exception.productInvalid", codigo.getValue().toString());
			return null;
		}
		return ProductMapper.INSTANCE.getByDto(product.get());
	}

	@Override
	public List<Product> findByCodes(List<Id> codes)
	{
		return  ProductMapper.INSTANCE.getListByDto(repo.findAllById(
				codes.stream().map(Id::getValue).collect(Collectors.toList())
		));
	}

	@Override
	public Product save(Product producto)
	{
		ProductDto p = ProductMapper.INSTANCE.getDto(producto);
		return  ProductMapper.INSTANCE.getByDto(repo.save(p));
	}

	@Override
	public Product update(Product producto)
	{
		this.findByCode(producto.getId());
		return  this.save(producto);
	}

	@Override
	public void deleteByCode(Id codigo)
	{
		this.findByCode(codigo);
		repo.deleteById(codigo.getValue());
	}

	@Override
	public String exportReport(String reportFormat)
	{
		//Get Products
		List<ProductDto> products = this.repo.findAll();
		String path = "C:\\Users\\Public\\Downloads";
		
		//Load File and compile it
		try {
			File file = ResourceUtils.getFile("classpath:productReport.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(products);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("create_by", "Eliot Musk");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
			if(reportFormat.equalsIgnoreCase("html")) 
				JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\products.html");
			if(reportFormat.equalsIgnoreCase("pdf"))
				JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\products.pdf");
			
		} catch (FileNotFoundException e) {
			return "FileNotFoundException";
		} catch (JRException e) {
			return "JRException";
		}
		
		return "Report Generate In Path" + path;
	}
}
