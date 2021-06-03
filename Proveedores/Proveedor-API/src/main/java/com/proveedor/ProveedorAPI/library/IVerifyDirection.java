package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public interface IVerifyDirection 
{
    // the Direction must start with "CL" and vocales number must three
    public void VerifyDirection(String direccion);
}
