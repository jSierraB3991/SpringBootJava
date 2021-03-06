package com.example.gateway.secondservice.infrastructure.mapper;

import java.util.UUID;

import com.example.gateway.secondservice.domain.model.User;
import com.example.gateway.secondservice.infrastructure.dto.UserDto;
import com.example.gateway.secondservice.infrastructure.rest.UserRest;
import com.example.gateway.secondservice.shared.domain.model.CreationDate;
import com.example.gateway.secondservice.shared.domain.model.IdUser;
import com.example.gateway.secondservice.shared.domain.model.LastNameUser;
import com.example.gateway.secondservice.shared.domain.model.NameUser;
import com.example.gateway.secondservice.shared.infrastructure.mapper.Mapper;

public class UserMapper implements Mapper<UserRest, UserDto, User> {

	public static UserMapper INSTANCE = new UserMapper();
	
	@Override
	public UserRest GetRest(User domain) {
		return new UserRest(domain.getId().getValue(), domain.getName().getValue(),
				domain.getLastName().getValue(), domain.getDateCreation().getValue());
	}

	@Override
	public UserDto GetDto(User domain) {
		return new UserDto(UUID.fromString(domain.getId().getValue()), domain.getName().getValue(),
				domain.getLastName().getValue(), domain.getDateCreation().getValue());
	}

	@Override
	public User GetDomainByRest(UserRest rest) {
		return User.of(new IdUser(rest.getId()), new NameUser(rest.getName()),
				new LastNameUser(rest.getLastName()), new CreationDate(rest.getDateCreation()));
	}

	@Override
	public User GetDomainByDto(UserDto dto) {
		return User.of(new IdUser(dto.getId().toString()), new NameUser(dto.getName()),
				new LastNameUser(dto.getLastName()), new CreationDate(dto.getDateCreation()));
	}

}
