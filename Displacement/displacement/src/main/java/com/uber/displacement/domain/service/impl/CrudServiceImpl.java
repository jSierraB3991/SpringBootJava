package com.uber.displacement.domain.service.impl;

import com.uber.displacement.domain.model.BaseEntity;
import com.uber.displacement.domain.service.CrudService;
import com.uber.displacement.infrastructure.Exception.DeleteDriverVehicleException;
import com.uber.displacement.infrastructure.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public abstract class CrudServiceImpl<Model extends BaseEntity> implements CrudService<Model> {

    private final JpaRepository<Model, Integer> repository;

    @Override
    public List<Model> findAll() {
        return repository.findAll();
    }

    @Override
    public Model findById(int id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
    }

    @Override
    public Model save(Model model) {
        return repository.save(model);
    }

    @Override
    public Model update(Model model, int id) throws NotFoundException {
        findById(id);
        model.setId(id);
        return save(model);
    }

    @Override
    public void deleteById(int id) throws NotFoundException, DeleteDriverVehicleException {
        validateDelete(findById(id));
        repository.deleteById(id);
    }

    public abstract void validateDelete(Model model) throws DeleteDriverVehicleException;
}
