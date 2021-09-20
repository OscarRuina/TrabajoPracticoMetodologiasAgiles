package com.unla.pedidosya.model;

import java.util.List;

public class NegocioModel {
    
    private long idNegocio;
    private String nombre;
    private String direccion;
    private String localidad;
    private int telefono;
    private List<ProductoModel> productos;

    public NegocioModel(){}

    public NegocioModel(long idNegocio, String nombre, String direccion, String localidad,int telefono){
        this.idNegocio = idNegocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public long getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(long idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<ProductoModel> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoModel> productos) {
        this.productos = productos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
