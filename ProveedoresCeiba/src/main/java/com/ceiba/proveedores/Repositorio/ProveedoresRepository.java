package com.ceiba.proveedores.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.proveedores.modelo.Proveedor;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedor, Integer>
{
}