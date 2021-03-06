package com.example.demomongo.data.changelogs;

import java.util.ArrayList;
import java.util.List;

import com.example.demomongo.model.Country;
import com.example.demomongo.repository.CountryRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

@ChangeLog(order = "001")
public class ChangeLog01 
{
	@ChangeSet(order = "001", id = "importCountry", author = "JDSierra")
	public void importCountry(CountryRepository countryRepository){
    	
    	List<Country> countries = new ArrayList<>();
    	countries.add(Country.builder()
				.code("COL")
				.name("Colombia")
				.build());
    	countries.add(Country.builder()
				.code("BR")
				.name("Brazil")
				.build());
    	countries.add(Country.builder()
				.code("JP")
				.name("Japón")
				.build());
		countryRepository.saveAll(countries);
	}
}
