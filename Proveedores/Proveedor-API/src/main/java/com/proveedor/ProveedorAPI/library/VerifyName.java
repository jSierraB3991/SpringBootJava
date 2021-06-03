package com.proveedor.ProveedorAPI.library;

import org.springframework.stereotype.Component;

@Component
public class VerifyName implements IVerifyName{

    @Override
    public void VerifyName(String name) 
    {
        if(name.trim().length() < 5)
            throw new RuntimeException("The name of provider must low five(5)"
                    + " characters");
        
        String palindrome = new String();
        char [] invertir = name.toLowerCase().trim().toCharArray();
        for(int i = invertir.length-1 ; i>=0; i--){
            if(invertir[i] != ' ')
                palindrome += invertir[i];
        }
        
        if(name.replaceAll(" ", "").toLowerCase().equals(palindrome))
            throw new RuntimeException("The name cannot be palindrome");
    }
    
}
