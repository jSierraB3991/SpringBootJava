package com.proveedor.ProveedorAPI.service;

import com.proveedor.ProveedorAPI.models.Provider;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProviderService 
{
    List<Provider> getAllProviders();
    Provider getOneProvider(int id);
    Provider addProvider(Provider p);
    Provider editProvider(Provider p);
}
