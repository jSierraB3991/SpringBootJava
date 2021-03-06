package com.example.reactor.demoreactor.model;

import java.time.LocalDateTime;

public class Sale
{
    private Integer id;
    private LocalDateTime fecha;

    public Sale(Integer id, LocalDateTime fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta:{ " + "id: " + id + ", fecha: " + fecha + " }";
    }
}
