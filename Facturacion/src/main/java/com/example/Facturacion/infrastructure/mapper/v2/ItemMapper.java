package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.Item;
import com.example.Facturacion.infrastructure.dto.ItemDto;
import com.example.Facturacion.infrastructure.rest.ItemRest;
import com.example.Facturacion.shared.domain.CountItem;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.ValueItem;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class ItemMapper implements GenericMapper<ItemRest, Item, ItemDto> 
{
	public static final ItemMapper INSTANCE = new ItemMapper();

	@Override
	public ItemRest getRest(Item domain) 
	{
		return new ItemRest(domain.getCodigo().getValue(), domain.getCantidad().getValue(),
				ProductMapper.INSTANCE.getRest(domain.getProducto()), domain.getValor().getValue());
	}

	@Override
	public ItemDto getDto(Item domain) 
	{
		return new ItemDto(domain.getCodigo().getValue(), domain.getCantidad().getValue(),
				domain.getValor().getValue(), ProductMapper.INSTANCE.getDto(domain.getProducto()));
	}

	@Override
	public Item getByRest(ItemRest rest) 
	{
		return Item.of(new Codigo(rest.getCodigo()), new CountItem(rest.getCantidad()), 
				ProductMapper.INSTANCE.getByRest(rest.getProducto()), new ValueItem(rest.getValor()));
	}

	@Override
	public Item getByDto(ItemDto dto) 
	{
		return Item.of(new Codigo(dto.getCodigo()), new CountItem(dto.getCantidad()), 
				ProductMapper.INSTANCE.getByDto(dto.getProducto()), new ValueItem(dto.getValor()));
	}

}
