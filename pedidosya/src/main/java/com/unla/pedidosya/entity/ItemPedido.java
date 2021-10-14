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
@Table(name = "ItemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItemPedido")
    private long idItemPedido;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "subtotal", nullable = false)
    private float subtotal;

    @ManyToOne(cascade = { /* CascadeType.PERSIST, */ CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(int cantidad, Producto producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.setSubtotal();
        this.pedido = pedido;
    }

    public ItemPedido(long idItemPedido, int cantidad, float subtotal, Producto producto) {
        this.idItemPedido = idItemPedido;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public long getIdItemPedido() {
        return this.idItemPedido;
    }

    public void setIdItemPedido(long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal() {
        this.subtotal = (this.producto.getPrecio()) * (this.cantidad);
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "{" + " idItemPedido='" + getIdItemPedido() + "'" + ", cantidad='" + getCantidad() + "'" + ", subtotal='"
                + getSubtotal() + "'" + ", producto='" + getProducto() + "'" + "}";
    }

}
