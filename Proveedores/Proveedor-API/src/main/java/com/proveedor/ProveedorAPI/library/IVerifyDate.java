package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public interface IVerifyDate 
{
    // the registration date cannot be sunday
    public void VerifyDate(String day);
}
