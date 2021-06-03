package com.uber.displacement.domain.service.impl;

import com.uber.displacement.domain.model.Driver;
import com.uber.displacement.domain.service.DriverService;
import com.uber.displacement.infrastructure.Exception.DeleteDriverVehicleException;
import com.uber.displacement.infrastructure.repository.DriverRepository;
import com.uber.displacement.infrastructure.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends CrudServiceImpl<Driver> implements DriverService {

    private final VehicleRepository vehicleRepository;

    public DriverServiceImpl(DriverRepository repository, VehicleRepository vehicleRepository) {
        super(repository);
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void validateDelete(Driver driver) throws DeleteDriverVehicleException {
        if(vehicleRepository.countByDriver(driver) > 0){
            throw new DeleteDriverVehicleException("This driver is driving one or more vehicles");
        }
    }
}
