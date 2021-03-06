package com.example.reactor.facturareactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product implements Serializable
{
 	private static final long serialVersionUID = -1968732447409741617L;
	@Id
    private String id = new ObjectId().toString();
    private String name;
    private String marca;
    private BigDecimal price;
    private String imageUrl;
}
