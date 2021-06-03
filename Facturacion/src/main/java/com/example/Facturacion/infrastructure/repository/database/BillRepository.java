package com.example.Facturacion.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Facturacion.infrastructure.dto.BillDto;

@Repository
public interface BillRepository extends JpaRepository<BillDto, String> {

}