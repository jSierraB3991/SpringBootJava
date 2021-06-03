package com.proveedor.ProveedorAPI.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class holaController 
{    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/hola", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String Hola() 
    {
        return "Hola Mundo";
    }
}
