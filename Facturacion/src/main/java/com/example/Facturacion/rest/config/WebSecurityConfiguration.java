package com.example.Facturacion.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.Facturacion.domain.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	private final UserService userService;
	private final String tokenSecurity;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public WebSecurityConfiguration(UserService userService,
			@Value("${security.key}") String tokenSecurity,
			BCryptPasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.tokenSecurity = tokenSecurity;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/api/user").permitAll()
			.antMatchers("/api/reports/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new LoginFilter("/login", authenticationManager(), tokenSecurity), 
					UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JwtFilter(tokenSecurity), UsernamePasswordAuthenticationFilter.class);
	}
}
