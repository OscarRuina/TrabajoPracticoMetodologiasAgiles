package com.unla.pedidosya.model;

public class ProductoModel {
    
    private long idProducto;
    private String nombre;
    private String descripcion;
    private String tipo;
    private float precio;

    public ProductoModel(){}

    public ProductoModel(long idProducto, String nombre, String descripcion, String tipo, float precio) {
        this.idProducto = idProducto;
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

}
