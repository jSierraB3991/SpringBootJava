package com.uber.displacement.domain.service;

import com.uber.displacement.domain.dto.FilterVehicle;
import com.uber.displacement.domain.model.Vehicle;

import java.util.List;

public interface VehicleService extends CrudService<Vehicle> {

    List<Vehicle> findAllSearch(FilterVehicle filter);
}
