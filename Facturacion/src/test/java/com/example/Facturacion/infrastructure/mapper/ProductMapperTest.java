package com.example.Facturacion.infrastructure.mapper;

import static org.junit.Assert.assertEquals;

import com.example.Facturacion.domain.modeldomain.Product;
import com.example.Facturacion.infrastructure.dto.ProductDto;
import com.example.Facturacion.infrastructure.mapper.v2.ProductMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductMapperTest
{
    Logger logger = LoggerFactory.getLogger(ProductMapperTest.class);

    private final Integer code = 1;
    private final String name = "Pony Malta";
    private final Double value = 6000.0;

    @Test
    void DtoToDomain()
    {
        logger.info("START TEST OF PRODUCT DTO TO DOMAIN");
        Product pDomain = ProductMapper.INSTANCE.getByDto(new ProductDto(code, name, value));
        assertEquals(code, pDomain.getId().getValue());
        assertEquals(name, pDomain.getNombre().getValue());
        assertEquals(value, pDomain.getValor().getValue());
        logger.info("FINALLY TEST OF PRODUCT DTO TO DOMAIN");
    }
}
