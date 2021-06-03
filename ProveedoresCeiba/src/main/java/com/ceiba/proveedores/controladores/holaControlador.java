package com.ceiba.proveedores.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/")
public class holaControlador 
{

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/hola", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String Hola() {
		return "Hola Mundo";
	}
}
