package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public class VerifyDirection implements IVerifyDirection{

    @Override
    public void VerifyDirection(String direccion) 
    {
        if(!direccion.toLowerCase().startsWith("cl"))
            throw new RuntimeException("The direction must start with CL");
        String regexExp = "[^aeiou]";
        int cantidad = direccion.replaceAll(regexExp, "").trim().toLowerCase().length();
        if(cantidad != 3)
            throw new RuntimeException("The direction must three (3) vowels");
    }
    
}
