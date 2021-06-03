package com.uber.displacement.infrastructure.mapper;

import com.uber.displacement.domain.dto.VehicleDto;
import com.uber.displacement.domain.model.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends AutoMapper<Vehicle, VehicleDto> {
}
