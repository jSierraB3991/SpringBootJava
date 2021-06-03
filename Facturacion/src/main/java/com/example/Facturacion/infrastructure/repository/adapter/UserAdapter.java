package com.example.Facturacion.infrastructure.repository.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Facturacion.domain.modeldomain.UserDomain;
import com.example.Facturacion.domain.service.UserService;
import com.example.Facturacion.infrastructure.dto.UserDto;
import com.example.Facturacion.infrastructure.mapper.v2.UserMapper;
import com.example.Facturacion.infrastructure.repository.database.UserRepository;
import com.example.Facturacion.shared.infrastructure.Util.Util;

@Service
public class UserAdapter implements UserService
{
	private final UserRepository repository;
	
	public UserAdapter(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<GrantedAuthority> getListAuthority()
	{
		String[] roles = { "LECTOR", "USUARIO", "ADMINISTRADOR" };
		List<GrantedAuthority> auths = new ArrayList<>();
		for (String rol : roles) {
			auths.add(new SimpleGrantedAuthority(rol));
		}
		return auths;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserDto> userO = repository.findByUserApp(username);
		if(!userO.isPresent()) {
			Util.throwException("userOrPasswordIncorrect", username);
		}
		return new User(userO.get().getUserApp(), userO.get().getPassword(),
				true, true, true, true, getListAuthority());
	}

	@Override
	public UserDomain save(UserDomain userDomain) 
	{
		UserDto userDto = repository.save(UserMapper.INSTANCE.getDto(userDomain));
		return UserMapper.INSTANCE.getByDto(userDto);
	}
}
