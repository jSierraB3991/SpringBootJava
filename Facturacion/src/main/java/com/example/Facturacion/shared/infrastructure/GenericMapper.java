package com.example.Facturacion.shared.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<R, M, D>
{
	R getRest(M domain);
	
	D getDto(M domain);
	
	M getByRest(R rest);
	
	M getByDto(D dto);
	
	default List<R> getListRest(List<M> domains){
		return domains.stream().map(this::getRest).collect(Collectors.toList());
	}
	
	default List<D> getListDto(List<M> domains){
		return domains.stream().map(this::getDto).collect(Collectors.toList());
	}
	
	default List<M> getListByRest(List<R> rests){
		return rests.stream().map(this::getByRest).collect(Collectors.toList());
	}
	
	default List<M> getListByDto(List<D> dtos){
		return dtos.stream().map(this::getByDto).collect(Collectors.toList());
	}
}
