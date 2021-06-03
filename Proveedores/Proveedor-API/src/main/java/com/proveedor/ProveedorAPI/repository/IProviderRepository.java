package com.proveedor.ProveedorAPI.repository;

import com.proveedor.ProveedorAPI.models.Provider;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Integer> {
    
}
