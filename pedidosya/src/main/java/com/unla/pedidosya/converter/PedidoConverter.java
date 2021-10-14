package com.unla.pedidosya.converter;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.model.PedidoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("pedidoConverter")
public class PedidoConverter {
    @Autowired
    private NegocioConverter converter;

    public PedidoModel entityToModel(Pedido p) {
        NegocioModel model = converter.entityToModel(p.getNegocio());
        return new PedidoModel(p.getIdPedido(), p.getNombre(), p.getDireccion(), p.getTelefono(), model,
                p.getPrecioTotal(), p.isListo());
    }

    public Pedido modelToEntity(PedidoModel p) {
        Negocio entity = converter.modelToEntity(p.getNegocio());
        return new Pedido(p.getIdPedido(), p.getNombre(), p.getDireccion(), p.getTelefono(), entity, p.getPrecioTotal(),
                p.isListo());

    }

}