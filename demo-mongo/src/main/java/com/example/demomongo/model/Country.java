package com.example.demomongo.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Country implements Serializable
{
	private static final long serialVersionUID = -9094980018229217592L;
	private String id;
	private String code;
	private String name;
}
