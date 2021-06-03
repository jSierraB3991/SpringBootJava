package com.uber.displacement.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterVehicle {

    private String plaque;
    private String marc;
    private String model;
    private String nameDriver;
}
