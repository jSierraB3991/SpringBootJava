package com.example.Facturacion.infrastructure.repository.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Facturacion.infrastructure.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String>
{
	Optional<UserDto> findByUserApp(String userApp);
}
