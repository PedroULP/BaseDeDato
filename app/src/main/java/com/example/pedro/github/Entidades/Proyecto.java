package com.example.pedro.github.Entidades;

public class Proyecto {

    public String descripcion;
    public double costo;
    public Cliente cliente_id;

    public Proyecto(String descripcion, double costo, Cliente cliente_id) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.cliente_id = cliente_id;
    }

    public Proyecto() {}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }


}
