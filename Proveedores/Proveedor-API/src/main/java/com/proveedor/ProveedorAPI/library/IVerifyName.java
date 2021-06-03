package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public interface IVerifyName 
{
    // The name must low 5 characters and cannot be palidrome
    public void VerifyName(String name);
}
