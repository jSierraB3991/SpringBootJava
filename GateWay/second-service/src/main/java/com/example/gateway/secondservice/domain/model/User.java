package com.example.gateway.secondservice.domain.model;

import java.util.Optional;
import java.util.UUID;

import com.example.gateway.secondservice.shared.domain.model.CreationDate;
import com.example.gateway.secondservice.shared.domain.model.IdUser;
import com.example.gateway.secondservice.shared.domain.model.LastNameUser;
import com.example.gateway.secondservice.shared.domain.model.NameUser;

public class User {

	private final IdUser id;
	private final NameUser name;
	private final LastNameUser lastName;
	private final CreationDate dateCreation;
	
	private User(IdUser id, NameUser name, LastNameUser lastName, CreationDate dateCreation) {
		super();
		this.id = Optional.ofNullable(id.getValue()).isPresent() ? id : new IdUser(UUID.randomUUID().toString());
		this.name = name;
		this.lastName = lastName;
		this.dateCreation = dateCreation;
	}
	
	public static User of(IdUser id, NameUser name, LastNameUser lastName
			, CreationDate dateCreation) {
		return new User(id, name, lastName, dateCreation);
	}

	public IdUser getId() {
		return id;
	}

	public NameUser getName() {
		return name;
	}

	public LastNameUser getLastName() {
		return lastName;
	}

	public CreationDate getDateCreation() {
		return dateCreation;
	}
}
