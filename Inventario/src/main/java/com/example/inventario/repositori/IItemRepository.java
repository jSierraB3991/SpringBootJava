package com.example.inventario.repositori;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.inventario.model.Item;
import com.example.inventario.model.Product;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByFactura(int factura);
}
