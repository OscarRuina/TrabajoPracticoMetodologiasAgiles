package com.unla.pedidosya.converter;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.model.ProductoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productoConverter")
public class ProductoConverter {

    @Autowired
    private NegocioConverter converter;

    public ProductoModel entityToModel(Producto p){
        NegocioModel model = converter.entityToModel(p.getNegocio());
        return new ProductoModel(p.getIdProducto() ,p.getNombre(), p.getDescripcion(), p.getTipo(), p.getPrecio(), model);
    }

    public Producto modelToEntity(ProductoModel p){
        Negocio entity = converter.modelToEntity(p.getNegocio());
        return new Producto(p.getNombre(), p.getDescripcion(), p.getTipo(), p.getPrecio(), entity);
    }
    
}