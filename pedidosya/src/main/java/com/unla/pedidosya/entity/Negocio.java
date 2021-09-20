package com.unla.pedidosya.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "negocio")
public class Negocio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNegocio")
    private long idNegocio;

    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

    @Column(name = "direccion",length = 50,nullable = false)
    private String direccion;

    @Column(name = "localidad",length = 50,nullable = false)
    private String localidad;

    @Column(name = "telefono",nullable = false)
    private int telefono;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "negocio" , cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
    private List<Producto> productos;

    public Negocio() {}

    public Negocio(String nombre, String direccion, String localidad,int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public long getIdNegocio() {
        return idNegocio;
    }

    protected void setIdNegocio(long idNegocio) {
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
    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Negocio [direccion=" + direccion + ", localidad=" + localidad + ", nombre=" + nombre + ", telefono="
                + telefono + "]";
    }

}
