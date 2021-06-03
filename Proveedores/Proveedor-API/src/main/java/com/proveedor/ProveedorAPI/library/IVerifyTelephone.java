package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public interface IVerifyTelephone 
{
    // the telephone must numeric and seven character
    public void VerifyTelephone(String telephone);
}
