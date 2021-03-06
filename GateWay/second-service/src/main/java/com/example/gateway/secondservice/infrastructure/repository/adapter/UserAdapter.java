package com.example.gateway.secondservice.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gateway.secondservice.domain.model.User;
import com.example.gateway.secondservice.domain.service.UserService;
import com.example.gateway.secondservice.infrastructure.dto.UserDto;
import com.example.gateway.secondservice.infrastructure.mapper.UserMapper;
import com.example.gateway.secondservice.infrastructure.repository.database.UserRepository;
import com.example.gateway.secondservice.shared.domain.model.IdUser;
import com.example.gateway.secondservice.shared.infrastructure.exception.DuplicatedNameAndLastName;
import com.example.gateway.secondservice.shared.infrastructure.exception.UserNotValidException;

@Service
public class UserAdapter implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> finAll() {
		return UserMapper.INSTANCE.GetDomainByDto(userRepository.findAll());
	}

	@Override
	public User findById(IdUser id) {
		return UserMapper.INSTANCE.GetDomainByDto(userRepository.findById(UUID.fromString(id.getValue()))
				.orElseThrow(() -> new UserNotValidException(id.getValue().toString())));
	}

	@Override
	public User save(User user) 
	{
		Optional<UserDto> userDto = userRepository.findAll().stream()
				.filter(userd -> userd.getName().equalsIgnoreCase(user.getName().getValue()))
				.filter(userd -> userd.getLastName().equalsIgnoreCase(user.getLastName().getValue())).findFirst();
		
		if(userDto.isPresent() && !userDto.get().getId().equals(user.getId().getValue()))
			throw new DuplicatedNameAndLastName(user.getName().getValue() + " " + user.getLastName().getValue());
		
		return UserMapper.INSTANCE.GetDomainByDto(
				userRepository.save(UserMapper.INSTANCE.GetDto(user)));
	}

	@Override
	public User update(User user) {
		findById(user.getId());
		return save(user);
	}

	@Override
	public void delete(IdUser id) {
		userRepository.deleteById(UUID.fromString(id.getValue()));
	}

}
