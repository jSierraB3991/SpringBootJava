package com.uber.displacement.infrastructure.controller;

import com.uber.displacement.domain.model.BaseEntity;
import com.uber.displacement.domain.service.CrudService;
import com.uber.displacement.infrastructure.Exception.DeleteDriverVehicleException;
import com.uber.displacement.infrastructure.Exception.NotFoundException;
import com.uber.displacement.infrastructure.mapper.AutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
public abstract class CrudController<Rest, Model extends BaseEntity> {

    private final CrudService<Model> service;
    private final AutoMapper<Model, Rest> mapper;

    @GetMapping
    public List<Rest> findALl(){
        return mapper.getDto(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rest> findById(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(mapper.getDto(service.findById(id)));
        }catch (NotFoundException ex){
            return ResponseEntity.notFound().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rest> save(@RequestBody Rest body){
        try{
            Model model = mapper.getEntity(body);
            model.setId(0);
            return ResponseEntity.ok(mapper.getDto(service.save(model)));
        }catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rest> update(@RequestBody Rest body, @PathVariable("id") Integer id){
        try{
            Model model = mapper.getEntity(body);
            if(!model.getId().equals(id)){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(mapper.getDto(service.update(model, id)));
        }catch (NotFoundException ex){
            return ResponseEntity.notFound().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteById(@PathVariable("id") Integer id){
        try{
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (NotFoundException ex){
            return new ResponseEntity<>(
                    ex.getMessage(),
                    HttpStatus.NOT_FOUND);
        }catch (DeleteDriverVehicleException ex){
            return new ResponseEntity<>(
                    ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex){
            return new ResponseEntity<>(
                    ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
