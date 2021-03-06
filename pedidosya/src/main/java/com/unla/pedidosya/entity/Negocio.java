package com.unla.pedidosya.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "negocio")
public class Negocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNegocio")
    private long idNegocio;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;

    @Column(name = "localidad", length = 50, nullable = false)
    private String localidad;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "negocio", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
    private List<Producto> productos; /* ver si conviene usar un set en vez de list */

    @ManyToOne(
    /*
     * cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
     * CascadeType.REFRESH}
     */
    )
    @JoinColumn(name = "user_id")
    private User vendedor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "negocio", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
    private List<Pedido> pedidos;

    public Negocio() {
    }

    public Negocio(String nombre, String direccion, String localidad, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public Negocio(String nombre, String direccion, String localidad, int telefono, User vendedor) {
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

    public User getVendedor() {
        return vendedor;
    }

    public void setVendedor(User vendedor) {
        this.vendedor = vendedor;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "{" + " idNegocio='" + getIdNegocio() + "'" + ", nombre='" + getNombre() + "'" + ", direccion='"
                + getDireccion() + "'" + ", localidad='" + getLocalidad() + "'" + ", telefono='" + getTelefono() + "'"
                + ", vendedor='" + getVendedor() + "'" + "}";
    }

}
