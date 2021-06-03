package com.proveedor.ProveedorAPI.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;
    @Column
    private String _nombre;
    @Column
    private String _fecharegistro;
    @Column
    private String _telefono;
    @Column
    private String direccion;
    
    public Provider() { }

    public int getId() { return _id; }
    public void setId(int _id) { this._id = _id; }

    public String getNombre() { return _nombre; }
    public void setNombre(String _nombre) { this._nombre = _nombre; }

    public String getFecharegistro() { return _fecharegistro; }
    public void setFecharegistro(String _fecharegistro) { this._fecharegistro = _fecharegistro; }

    public String getTelefono() { return _telefono; }
    public void setTelefono(String _telefono) { this._telefono = _telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }    
}
