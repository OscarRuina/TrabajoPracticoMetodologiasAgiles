package com.unla.pedidosya.converter;

import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.model.ProductoModel;


import org.springframework.stereotype.Component;

@Component("productoConverter")
public class ProductoConverter {

    public ProductoModel entityToModel(Producto p){
        return new ProductoModel(p.getIdProducto() ,p.getNombre(), p.getDescripcion(), p.getTipo(), p.getPrecio());
    }

    public Producto modelToEntity(ProductoModel p){
        return new Producto(p.getNombre(), p.getDescripcion(), p.getTipo(), p.getPrecio());
    }
    
}