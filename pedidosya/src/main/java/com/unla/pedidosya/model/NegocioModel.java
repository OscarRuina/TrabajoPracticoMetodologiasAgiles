package com.unla.pedidosya.model;

public class NegocioModel {
    
    private long idNegocio;
    private String nombre;
    private String direccion;
    private String localidad;

    public NegocioModel(){}

    public NegocioModel(long idNegocio, String nombre, String direccion, String localidad){
        this.idNegocio = idNegocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
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

}
