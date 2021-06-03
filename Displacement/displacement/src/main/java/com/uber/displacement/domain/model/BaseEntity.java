package com.uber.displacement.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8599549827002531762L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
