package com.unla.pedidosya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "precio")
    private float precio;

    public Producto() {}

    public Producto(String nombre, String descripcion, String tipo, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }

    public long getIdProducto() {
        return idProducto;
    }

    protected void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Negocio [nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + ", precio="
                + precio + "]";
    }

}

