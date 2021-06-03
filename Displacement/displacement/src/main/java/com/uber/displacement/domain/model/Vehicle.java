package com.uber.displacement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle extends BaseEntity {

    private static final long serialVersionUID = -4234931619175569176L;

    @Column(unique = true, length = 10)
    private String plaque;
    private String marc;
    private String model;

    @ManyToOne
    private Driver driver;


}
