package com.example.Facturacion.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.domain.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController 
{
	private final ReportService reportService;
	
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping("/products/{report-format}")
	public String downloadReportProducts(@PathVariable("report-format") String reportFormat) 
	{
		return reportService.exportReport(reportFormat);
	}
}
