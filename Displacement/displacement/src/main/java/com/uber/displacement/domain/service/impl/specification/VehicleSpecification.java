package com.uber.displacement.domain.service.impl.specification;

import com.uber.displacement.domain.dto.FilterVehicle;
import com.uber.displacement.domain.model.Vehicle;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleSpecification {

    public static Specification<Vehicle> filterVehicle(FilterVehicle filter){

        return new Specification<Vehicle>() {
            @Override
            public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> pr = new ArrayList<>();
                if(!filter.getMarc().isEmpty()){
                    pr.add(cb.like(root.get("marc"), "%"  + filter.getMarc() + "%"));
                }if(!filter.getModel().isEmpty()){
                    pr.add(cb.like(root.get("model"), "%" + filter.getModel() + "%"));
                }if(!filter.getPlaque().isEmpty()){
                    pr.add(cb.like(root.get("plaque"), "%" + filter.getPlaque() + "%"));
                }if(!filter.getNameDriver().isEmpty()){
                    pr.add(cb.like(root.get("driver").get("name"), "%" + filter.getNameDriver() + "%"));
                }
                return cb.and(pr.toArray(new Predicate[pr.size()]));
            }
        };
    }
}
