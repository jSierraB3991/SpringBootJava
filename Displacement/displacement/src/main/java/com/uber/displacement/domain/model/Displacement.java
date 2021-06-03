package com.uber.displacement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "displacement")
@Getter
@Setter
@NoArgsConstructor
public class Displacement extends BaseEntity {

    @ManyToOne
    private Vehicle vehicle;

    private String origen;
    private String destiny;

    @Column(name = "origen_date")
    private LocalDate origenDate;

    @Column(name = "destiny_date")
    private LocalDate destinyDate;
}
