package com.unla.pedidosya.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private long idProducto;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "precio", nullable = false)
    private float precio;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "idNegocio", foreignKey = @ForeignKey(name = "FK_NEGOCIO_ID"), nullable = false)
    private Negocio negocio;
    /*
     * Agregue el foreignkey para ver porque ese creo que establece el nombre que
     * queres que aparezca en la tabla pero aparte porque creo que no haci bien la
     * relacion
     */

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    private Set<ItemPedido> itemsPedidos; /* ver si conviene usar un set en vez de list */

    public Producto() {
    }

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

    public Producto(Long idProducto, String nombre, String descripcion, String tipo, float precio, Negocio negocio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
        this.negocio = negocio;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
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
        return "{" + " idProducto='" + getIdProducto() + "'" + ", nombre='" + getNombre() + "'" + ", descripcion='"
                + getDescripcion() + "'" + ", tipo='" + getTipo() + "'" + ", precio='" + getPrecio() + "'"
                + ", negocio='" + getNegocio() + "'" + "}";
    }

}
