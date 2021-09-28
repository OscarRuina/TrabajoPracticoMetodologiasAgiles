package com.unla.pedidosya.model;

import com.unla.pedidosya.entity.User;
import java.util.List;

public class NegocioModel {

    private long idNegocio;
    private String nombre;
    private String direccion;
    private String localidad;
    private int telefono;
    private List<ProductoModel> productos;
    private User vendedor;

    public NegocioModel() {
    }

    public NegocioModel(long idNegocio, String nombre, String direccion, String localidad,
            int telefono, User vendedor) {
        this.idNegocio = idNegocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.vendedor = vendedor;
    }

    public NegocioModel(String nombre, String direccion, String localidad, int telefono,
            User vendedor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.vendedor = vendedor;
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

    public User getVendedor() {
        return vendedor;
    }

    public void setVendedor(User vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "{" +
                " idNegocio='" + getIdNegocio() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", direccion='" + getDireccion() + "'" +
                ", localidad='" + getLocalidad() + "'" +
                ", telefono='" + getTelefono() + "'" +
                ", productos='" + getProductos() + "'" +
                "}";
    }


}
