package com.example.Facturacion.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/demo")
public class DemoController 
{
	@Autowired
    private MessageSource messageSource;
     
    @GetMapping
    public String index() {
        return messageSource.getMessage("error.notfound", null, LocaleContextHolder.getLocale());
    }
}