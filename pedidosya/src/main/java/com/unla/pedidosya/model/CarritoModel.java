package com.unla.pedidosya.model;

import java.util.ArrayList;
import java.util.List;


public class CarritoModel {

    private long idCarrito;
    private List<ProductoModel> productos;
    private float precioTotal;
    
    public CarritoModel() {
        this.productos = new ArrayList<ProductoModel>();
    }

    public long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public List<ProductoModel> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoModel> productos) {
        this.productos = productos;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal() {
        this.precioTotal = calcularPrecioTotal();
    }

    /* agregar producto a la lista */
    public void agregarProducto(ProductoModel p){
        this.productos.add(p);
    }

    /*metodo que calcula el precio total por la lista de productos */
    private float calcularPrecioTotal(){
        float total=0;
        for (ProductoModel producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    
    
}
