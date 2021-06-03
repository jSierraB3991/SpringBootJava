package com.example.Facturacion.rest.config;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	private JwtUtil() { }

	public static void addAuthentication(HttpServletResponse response, String name, String tokenSecurity) {
		String token = Jwts.builder()
				.setSubject(name)
				.signWith(SignatureAlgorithm.HS512, tokenSecurity)
				.compact();
		response.addHeader("Authorization", "Bearer " + token);
	}
	
	public static Authentication getAuthentication(HttpServletRequest request, String tokenSecurity) 
	{
		String token = request.getHeader("Authorization");
		if(token!=null) {
			String user = Jwts.parser()
					.setSigningKey(tokenSecurity)
					.parseClaimsJws(token.replace("Bearer ", ""))
					.getBody()
					.getSubject();
			
			return Optional.ofNullable(user).isPresent()
					? new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>())
					: null;
		}
		
		return null;
	}

}
