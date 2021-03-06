package com.example.inventario.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventario.model.Factura;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer> {

}
