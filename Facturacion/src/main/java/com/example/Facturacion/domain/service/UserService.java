package com.example.Facturacion.domain.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Facturacion.domain.modeldomain.UserDomain;

public interface UserService extends UserDetailsService
{
	UserDomain save(UserDomain userDomain);
}
