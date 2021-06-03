package com.uber.displacement.infrastructure.mapper;

import com.uber.displacement.domain.dto.DriverDto;
import com.uber.displacement.domain.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends AutoMapper<Driver, DriverDto> {
}
