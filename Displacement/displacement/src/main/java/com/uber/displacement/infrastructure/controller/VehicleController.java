package com.uber.displacement.infrastructure.controller;

import com.uber.displacement.domain.dto.FilterVehicle;
import com.uber.displacement.domain.dto.VehicleDto;
import com.uber.displacement.domain.model.Vehicle;
import com.uber.displacement.domain.service.VehicleService;
import com.uber.displacement.infrastructure.mapper.VehicleMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/vehicle")
public class VehicleController extends CrudController<VehicleDto, Vehicle> {

    private final VehicleService service;
    private final VehicleMapper mapper;

    public VehicleController(VehicleService service, VehicleMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/search")
    public List<VehicleDto> findAllSearch(@RequestBody FilterVehicle filter){
        return mapper.getDto(service.findAllSearch(filter));
    }
}
