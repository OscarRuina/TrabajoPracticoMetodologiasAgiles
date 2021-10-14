package com.unla.pedidosya.converter;

import com.unla.pedidosya.entity.ItemPedido;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.model.ItemPedidoModel;
import com.unla.pedidosya.model.ProductoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ItemPedidoConverter")
public class ItemPedidoConverter {

    @Autowired
    private ProductoConverter converter;

    public ItemPedidoModel entityToModel(ItemPedido p) {
        ProductoModel entity = converter.entityToModel(p.getProducto());
        return new ItemPedidoModel(p.getIdItemPedido(), p.getCantidad(), p.getSubtotal(), entity);
    }

    public ItemPedido modelToEntity(ItemPedidoModel p) {
        Producto pm = converter.modelToEntity(p.getProducto());
        return new ItemPedido(p.getIdItemPedido(), p.getCantidad(), p.getSubtotal(), pm);
    }

}