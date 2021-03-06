package com.example.tenancy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tenancy.entity.City;
import com.example.tenancy.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController 
{
	@Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> getAll() throws SQLException {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> get(@PathVariable(value = "id") Long id) {
        City city = cityService.get(id).get();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<City> get(@PathVariable(value = "name") String name) {
        City city = cityService.getByName(name);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<City> delete(@PathVariable(value = "name") String name) 
    {
        cityService.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}