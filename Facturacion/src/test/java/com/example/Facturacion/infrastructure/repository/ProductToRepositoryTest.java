package com.example.Facturacion.infrastructure.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.Facturacion.infrastructure.dto.ProductDto;
import com.example.Facturacion.infrastructure.repository.database.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductToRepositoryTest
{
    private final String name = "Pony Malta";
    private final Double value = 6000.0;

    Logger logger = LoggerFactory.getLogger(ProductToRepositoryTest.class);

    @Autowired
    private ProductRepository productoRepository;

    @Test
    public void insertProduct()
    {
        logger.info("START TEST SAVE PROUCT REPOSITORY");
        ProductDto p = productoRepository.save(new ProductDto(0, name, value));
        assertNotEquals(0, p.getId());
        assertEquals(name, p.getNombre());
        assertEquals(value, p.getValor());
        logger.info("FINALLY TEST SAVE PROUCT REPOSITORY");
    }

}
