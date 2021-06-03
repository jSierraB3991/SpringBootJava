package com.uber.displacement.domain.service;

import com.uber.displacement.domain.model.BaseEntity;
import com.uber.displacement.infrastructure.Exception.DeleteDriverVehicleException;
import com.uber.displacement.infrastructure.Exception.NotFoundException;

import java.util.List;

public interface CrudService<Model extends BaseEntity> {

    List<Model> findAll();

    Model findById(int id) throws NotFoundException;

    Model save(Model model);

    Model update(Model model, int id) throws NotFoundException;

    void deleteById(int id) throws NotFoundException, DeleteDriverVehicleException;
}
