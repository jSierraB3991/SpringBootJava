package com.uber.displacement.domain.service.impl;

import com.uber.displacement.domain.dto.FilterVehicle;
import com.uber.displacement.domain.model.Vehicle;
import com.uber.displacement.domain.service.VehicleService;
import com.uber.displacement.domain.service.impl.specification.VehicleSpecification;
import com.uber.displacement.infrastructure.Exception.DeleteDriverVehicleException;
import com.uber.displacement.infrastructure.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl extends CrudServiceImpl<Vehicle> implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository repository) {
        super(repository);
        this.vehicleRepository = repository;
    }

    @Override
    public void validateDelete(Vehicle vehicle) throws DeleteDriverVehicleException {
    }

    @Override
    public List<Vehicle> findAllSearch(FilterVehicle filter) {
        return vehicleRepository.findAll(VehicleSpecification.filterVehicle(filter));
    }

}
