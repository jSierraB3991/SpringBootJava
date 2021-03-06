package com.example.tenancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tenancy.entity.City;

public interface CityRepository extends JpaRepository<City,Long> 
{
    City findByName(String name);
}
