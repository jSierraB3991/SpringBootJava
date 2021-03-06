package com.example.demomongo.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demomongo.model.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, Serializable> {

}
