package com.unla.pedidosya.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private long idPedido;

    @Column(name = "comprador", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "idNegocio", nullable = false)
    private Negocio negocio;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
    private Set<ItemPedido> itemsPedidos; /* ver si conviene usar un set en vez de list */


    @Column(name = "total", nullable = false)
    private float precioTotal;

    @Column(name = "listo")
    private boolean listo;

    public Pedido() {
    }

    public Pedido(String nombre, String direccion, int telefono, Negocio negocio, float precioTotal) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.negocio = negocio;
        this.precioTotal = precioTotal;
        this.listo = false;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Set<ItemPedido> getItemsPedidos() {
        return this.itemsPedidos;
    }

    public void setItemsPedidos(Set<ItemPedido> itemsPedidos) {
        this.itemsPedidos = itemsPedidos;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    @Override
    public String toString() {
        return "{" + " idPedido='" + getIdPedido() + "'" + ", nombre='" + getNombre() + "'" + ", direccion='"
                + getDireccion() + "'" + ", telefono='" + getTelefono() + "'" + ", negocio='" + getNegocio() + "'"
                + ", itemsPedidos='" + getItemsPedidos() + "'" + ", precioTotal='" + getPrecioTotal() + "'"
                + ", listo='" + isListo() + "'" + "}";

    }

}
