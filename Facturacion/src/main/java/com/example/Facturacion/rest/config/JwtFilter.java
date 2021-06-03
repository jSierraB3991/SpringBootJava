package com.example.Facturacion.rest.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean 
{
	private String tokenSecurity;
	
	public JwtFilter(String tokenSecurity) {
		this.tokenSecurity = tokenSecurity;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication auth = JwtUtil.getAuthentication((HttpServletRequest) request, tokenSecurity);	
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
	}
	
}
