package com.unla.pedidosya.model;

import java.util.List;

import com.unla.pedidosya.entity.Producto;

public class CarritoModel {

    private long idCarrito;
    private List<Producto> productos;
    private float precioTotal;
    
    public CarritoModel() {
    }

    public long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    
    
}
