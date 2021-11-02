package com.unla.pedidosya.model;

public class ItemPedidoModel {

    private long idItemPedido;
    private int cantidad;
    private float subtotal;
    private ProductoModel producto;
    private PedidoModel pedido;

    public ItemPedidoModel() {
    }

    public ItemPedidoModel(long idItemPedido, int cantidad, float subtotal, ProductoModel producto,
            PedidoModel pedido) {
        this.idItemPedido = idItemPedido;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
        this.pedido = pedido;
    }

    public ItemPedidoModel(long idItemPedido, int cantidad, float subtotal, ProductoModel producto) {
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

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoModel getProducto() {
        return this.producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public PedidoModel getPedido() {
        return this.pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "{" + " idItemPedido='" + getIdItemPedido() + "'" + ", cantidad='" + getCantidad() + "'" + ", subtotal='"
                + getSubtotal() + "'" + ", producto='" + getProducto() + "'" + ", pedido='" + getPedido() + "'" + "}";
    }

}
