package com.unla.pedidosya.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private List<ItemPedido> itemsPedidos; /* ver si conviene usar un set en vez de list */

    @Column(name = "total", nullable = false)
    private float precioTotal;

    @Column(name = "fechaInicio", columnDefinition = "TIMESTAMP")
    LocalDateTime fechaInicio;

    @Column(name = "listo", columnDefinition = /* "DATETIME */ "default false")
    private boolean listo;

    @Column(name = "fechaListo", columnDefinition = "TIMESTAMP")
    LocalDateTime fechaListo;

    @Column(name = "enCamino", columnDefinition = /* "Decimal(10,2) */ "default false")
    private boolean enCamino;

    @Column(name = "fechaEnCamino", columnDefinition = "TIMESTAMP")
    LocalDateTime fechaEnCamino;

    @Column(name = "entregado", columnDefinition = /* "Decimal(10,2) */ "default false")
    private boolean entregado;

    @Column(name = "fechaEntregado", columnDefinition = "TIMESTAMP")
    LocalDateTime fechaEntregado;

    public Pedido() {
    }

    public Pedido(String nombre, String direccion, int telefono, Negocio negocio, float precioTotal) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.negocio = negocio;
        this.precioTotal = precioTotal;
        this.listo = false;
        this.enCamino = false;
        this.entregado = false;
    }

    public Pedido(long idPedido, String nombre, String direccion, int telefono, Negocio negocio, float precioTotal,
            boolean listo) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.negocio = negocio;
        this.precioTotal = precioTotal;
        this.listo = listo;
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

    public List<ItemPedido> getItemsPedidos() {
        return this.itemsPedidos;
    }

    public void setItemsPedidos(List<ItemPedido> itemsPedidos) {
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

    public LocalDateTime getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean getListo() {
        return this.listo;
    }

    public LocalDateTime getFechaListo() {
        return this.fechaListo;
    }

    public void setFechaListo(LocalDateTime fechaListo) {
        this.fechaListo = fechaListo;
    }

    public boolean isEnCamino() {
        return this.enCamino;
    }

    public boolean getEnCamino() {
        return this.enCamino;
    }

    public void setEnCamino(boolean enCamino) {
        this.enCamino = enCamino;
    }

    public LocalDateTime getFechaEnCamino() {
        return this.fechaEnCamino;
    }

    public void setFechaEnCamino(LocalDateTime fechaEnCamino) {
        this.fechaEnCamino = fechaEnCamino;
    }

    public boolean isEntregado() {
        return this.entregado;
    }

    public boolean getEntregado() {
        return this.entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public LocalDateTime getFechaEntregado() {
        return this.fechaEntregado;
    }

    public void setFechaEntregado(LocalDateTime fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    @Override
    public String toString() {
        return "{" + " idPedido='" + getIdPedido() + "'" + ", nombre='" + getNombre() + "'" + ", direccion='"
                + getDireccion() + "'" + ", telefono='" + getTelefono() + "'" + ", negocio='" + getNegocio() + "'"
                + ", itemsPedidos='" + getItemsPedidos() + "'" + ", precioTotal='" + getPrecioTotal() + "'"
                + ", listo='" + isListo() + "'" + "}";

    }

}
