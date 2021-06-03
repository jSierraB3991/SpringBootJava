package com.example.Facturacion.rest.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.Facturacion.infrastructure.rest.UserRest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter
{
	private final String tokenSecurity;

	protected LoginFilter(String url, AuthenticationManager authenticationManager, 
			String tokenSecurity) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authenticationManager);
		this.tokenSecurity = tokenSecurity;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		InputStream body = request.getInputStream();
		
		UserRest userApp = new ObjectMapper().readValue(body, UserRest.class);
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(userApp.getUserApp(), 
						userApp.getPassword(),
						new ArrayList<>())
		);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		JwtUtil.addAuthentication(response, authResult.getName(), tokenSecurity);
	}

}
