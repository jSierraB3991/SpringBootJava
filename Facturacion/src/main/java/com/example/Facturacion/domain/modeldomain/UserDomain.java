package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.UserName;
import com.example.Facturacion.shared.domain.UserPassword;

public class UserDomain 
{
	private final UserName userApp;
	private final UserPassword password;
	
	private UserDomain(UserName userApp, UserPassword password) {
		this.userApp = userApp;
		this.password = password;
	}
	
	public static UserDomain of(UserName userApp, UserPassword password) {
		return new UserDomain(userApp, password);
	}

	public UserName getUserApp() {
		return userApp;
	}

	public UserPassword getPassword() {
		return password;
	}
}
