package com.uber.displacement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
@Getter
@Setter
@NoArgsConstructor
public class Driver extends BaseEntity {
    private static final long serialVersionUID = -5616324312831270437L;

    private String uuid;
    private String name;

    @Column(name = "last_name")
    private String lastName;

}
