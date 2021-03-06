package com.example.gateway.secondservice.infrastructure.repository.database;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gateway.secondservice.infrastructure.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, UUID> {

	
}
