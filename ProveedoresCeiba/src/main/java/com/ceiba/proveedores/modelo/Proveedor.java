package com.ceiba.proveedores.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Proveedor")
public class Proveedor 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;
    private Date fechaRegistro;
    private int telefono;
    private String direccion;

    public Proveedor() {
    }
    public Proveedor (String nombre, Date fechaRegistro, int telefono, String direccion) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Proveedor(Proveedor proveedor) 
    {
        this.nombre = proveedor.nombre;
        this.fechaRegistro = proveedor.fechaRegistro;
        this.telefono = proveedor.telefono;
        this.direccion = proveedor.direccion;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                ", Nombre='" + nombre + '\'' +
                ", FechaRegistro=" + fechaRegistro +'\'' +
                ", Telefono=" + telefono +'\'' +
                ", Direccion=" + direccion +
                '}';
    }
}