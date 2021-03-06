package com.example.tenancy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tenancy.entity.City;
import com.example.tenancy.repository.CityRepository;

@Service
public class CityService {
	@Autowired
    private CityRepository cityRepository;
	
	public void save(City city){
        cityRepository.save(city);
    }

    public List<City> getAll() throws SQLException {
        return cityRepository.findAll();

    }

    public Optional<City> get(Long id)
    {
        return cityRepository.findById(id);
    }

    public City getByName(String name){
        return cityRepository.findByName(name);
    }

    public void delete(String name)
    {
    	City city = this.cityRepository.findByName(name);
        cityRepository.delete(city);
    }
}