package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public class VerifyTelephone implements IVerifyTelephone {

    @Override
    public void VerifyTelephone(String telephone) 
    {
        if(!this.isNumber(telephone))
            throw new RuntimeException("The Telephone must be a number");
        
        if(telephone.length() != 7)
            throw new RuntimeException("The Telephone must be seven (7) character");
    }
    
    private Boolean isNumber(String number)
    {
        try{
            Integer.parseInt(number);
            return true;
        }
        catch(NumberFormatException ex) {
            return false;
        }
    }
    
}
