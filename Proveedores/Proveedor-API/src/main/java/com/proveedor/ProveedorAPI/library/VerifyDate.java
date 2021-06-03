package com.proveedor.ProveedorAPI.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class VerifyDate implements IVerifyDate {

    @Override
    public void VerifyDate(String day) 
    {
        if(!this.IsDate(day))
            throw new RuntimeException("The date of register is not a date");
        
        if(new Date(day).getDay() == 0)
            throw new RuntimeException("The sunday not can be register providers");
    }
    
    private Boolean IsDate(String day)
    {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateFormat.parse(day);
            return true;
        }
        catch(ParseException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
