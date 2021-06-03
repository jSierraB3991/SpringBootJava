package com.uber.displacement.infrastructure.repository;

import com.uber.displacement.domain.model.Driver;
import com.uber.displacement.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>, JpaSpecificationExecutor {

    long countByDriver(Driver driver);
}
