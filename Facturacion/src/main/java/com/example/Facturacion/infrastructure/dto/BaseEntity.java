package com.example.Facturacion.infrastructure.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCreacion", nullable = false, updatable = false )
	@CreatedDate
	@CreationTimestamp
	private Calendar fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaModificacion", nullable = false, updatable = true )
	@LastModifiedDate
	@UpdateTimestamp
	private Calendar  fechaModificacion;
}
