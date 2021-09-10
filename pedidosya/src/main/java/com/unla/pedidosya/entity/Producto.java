package com.unla.pedidosya.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private long idProducto;

    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

    @Column(name = "descripcion",length = 100,nullable = false)
    private String descripcion;

    @Column(name = "tipo",length = 50,nullable = false)
    private String tipo;

    @Column(name = "precio",nullable = false)
    private float precio;

    @ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
	@JoinColumn(name = "idNegocio",nullable = false)
    private Negocio negocio;

    public Producto() {}

    public Producto(String nombre, String descripcion, String tipo, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public Producto(String nombre, String descripcion, String tipo, float precio, Negocio negocio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
        this.negocio = negocio;
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
    
    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Negocio [nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + ", precio="
                + precio + "]";
    }

}

