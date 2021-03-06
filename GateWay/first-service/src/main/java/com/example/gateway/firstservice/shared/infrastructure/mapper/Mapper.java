package com.example.gateway.firstservice.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<Rest, Dto, Domain> {

	Rest GetRest(Domain domain);
	
	Dto GetDto(Domain domain);
	
	Domain GetDomainByRest(Rest rest);
	
	Domain GetDomainByDto(Dto dto);
	
	default List<Rest> GetRest(List<Domain> domains)
	{
		return domains.stream().map(domain -> this.GetRest(domain)).collect(Collectors.toList());
	}
	
	default List<Dto> GetDto(List<Domain> domains)
	{
		return domains.stream().map(domain -> this.GetDto(domain)).collect(Collectors.toList());
	}
	
	default List<Domain> GetDomainByRest(List<Rest> rests)
	{
		return rests.stream().map(rest -> this.GetDomainByRest(rest)).collect(Collectors.toList());
	}
	
	default List<Domain> GetDomainByDto(List<Dto> dtos)
	{
		return dtos.stream().map(dto -> this.GetDomainByDto(dto)).collect(Collectors.toList());
	}
}
