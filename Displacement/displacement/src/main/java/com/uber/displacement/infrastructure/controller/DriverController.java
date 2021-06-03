package com.uber.displacement.infrastructure.controller;

import com.uber.displacement.domain.dto.DriverDto;
import com.uber.displacement.domain.model.Driver;
import com.uber.displacement.domain.service.DriverService;
import com.uber.displacement.infrastructure.mapper.DriverMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/driver")
public class DriverController extends CrudController<DriverDto, Driver> {

    public DriverController(DriverService service, DriverMapper mapper) {
        super(service, mapper);
    }
}
