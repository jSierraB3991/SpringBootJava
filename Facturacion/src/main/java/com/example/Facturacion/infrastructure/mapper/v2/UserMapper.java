package com.example.Facturacion.infrastructure.mapper.v2;

import com.example.Facturacion.domain.modeldomain.UserDomain;
import com.example.Facturacion.infrastructure.dto.UserDto;
import com.example.Facturacion.infrastructure.rest.UserRest;
import com.example.Facturacion.shared.domain.UserName;
import com.example.Facturacion.shared.domain.UserPassword;
import com.example.Facturacion.shared.infrastructure.GenericMapper;

public class UserMapper implements GenericMapper<UserRest, UserDomain, UserDto> 
{
	public static final UserMapper INSTANCE = new UserMapper();

	@Override
	public UserRest getRest(UserDomain domain) {
		return new UserRest(domain.getUserApp().getValue(), 
				domain.getPassword().getValue());
	}

	@Override
	public UserDto getDto(UserDomain domain) {
		return new UserDto(0, domain.getUserApp().getValue(), 
				domain.getPassword().getValue());
	}

	@Override
	public UserDomain getByRest(UserRest rest) {
		return UserDomain.of(new UserName(rest.getUserApp()), 
				new UserPassword(rest.getPassword()));
	}

	@Override
	public UserDomain getByDto(UserDto dto) {
		return UserDomain.of(new UserName(dto.getUserApp()), 
				new UserPassword(dto.getPassword()));
	}

}
