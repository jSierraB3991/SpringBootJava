package com.uber.displacement.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private Integer id;
    private String plaque;
    private String Marc;
    private String model;
    private DriverDto driver;
}
