package com.example.tenancy.config.multitenat;

import java.util.Optional;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import com.example.tenancy.config.TenantContext;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver 
{
	 private String defaultTenant ="public";

	@Override
	public String resolveCurrentTenantIdentifier() {
		String t =  TenantContext.getCurrentTenant();
        if(Optional.ofNullable(t).isPresent()){
            return t;
        } else {
            return defaultTenant;
        }
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
