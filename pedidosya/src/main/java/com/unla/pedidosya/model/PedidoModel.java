package com.unla.pedidosya.model;

import java.util.List;

public class PedidoModel {
    private long idPedido;
    private String nombre;
    private String direccion;
    private int telefono;
    private NegocioModel negocio;
    private List<ItemPedidoModel> itemsPedidos;
    private float precioTotal;
    private boolean listo;

    public PedidoModel() {
    }

    public PedidoModel(long idPedido, String nombre, String direccion, int telefono, NegocioModel negocio,
            List<ItemPedidoModel> itemsPedidos, float precioTotal, boolean listo) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.negocio = negocio;
        this.itemsPedidos = itemsPedidos;
        this.precioTotal = precioTotal;
        this.listo = listo;
    }

    public PedidoModel(long idPedido, String nombre, String direccion, int telefono, NegocioModel negocio,
            float precioTotal, boolean listo) {
        this.idPedido = idPedido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.negocio = negocio;
        this.precioTotal = precioTotal;
        this.listo = listo;
    }

    public long getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public NegocioModel getNegocio() {
        return this.negocio;
    }

    public void setNegocio(NegocioModel negocio) {
        this.negocio = negocio;
    }

    public List<ItemPedidoModel> getItemsPedidos() {
        return this.itemsPedidos;
    }

    public void setItemsPedidos(List<ItemPedidoModel> itemsPedidos) {
        this.itemsPedidos = itemsPedidos;
    }

    public float getPrecioTotal() {
        return this.precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isListo() {
        return this.listo;
    }

    public boolean getListo() {
        return this.listo;
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
