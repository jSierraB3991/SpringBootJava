package com.proveedor.ProveedorAPI.service;

import com.proveedor.ProveedorAPI.library.IVerifyDate;
import com.proveedor.ProveedorAPI.library.IVerifyDirection;
import com.proveedor.ProveedorAPI.library.IVerifyName;
import com.proveedor.ProveedorAPI.library.IVerifyTelephone;
import com.proveedor.ProveedorAPI.models.Provider;
import com.proveedor.ProveedorAPI.repository.IProviderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService implements IProviderService{

    @Autowired
    private IProviderRepository repository;
    @Autowired
    private IVerifyName logicName;
    @Autowired
    private IVerifyDirection logicDirection;
    @Autowired
    private IVerifyTelephone logicTelephone;
    @Autowired
    private IVerifyDate logicDate;
    
    @Override
    public List<Provider> getAllProviders() {
        return this.repository.findAll();
    }

    @Override
    public Provider getOneProvider(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Provider addProvider(Provider p) {
        this.VerifyProvider(p);
        this.logicDate.VerifyDate(p.getFecharegistro());
        return this.repository.save(p);
    }
    
    @Override
    public Provider editProvider(Provider p) {
        this.VerifyProvider(p);
        p.setFecharegistro(this.repository.findById(p.getId()).get().getFecharegistro());
        return this.repository.save(p);
    }
    
    private void VerifyProvider(Provider p)
    {
        logicName.VerifyName(p.getNombre());
        logicDirection.VerifyDirection(p.getDireccion());
        logicTelephone.VerifyTelephone(p.getTelefono());
    }
}
