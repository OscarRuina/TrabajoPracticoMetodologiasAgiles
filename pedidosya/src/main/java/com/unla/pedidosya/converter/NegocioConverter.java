package com.unla.pedidosya.converter;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.model.NegocioModel;

import org.springframework.stereotype.Component;

@Component("negocioConverter")
public class NegocioConverter {

    public NegocioModel entityToModel(Negocio n){
        return new NegocioModel(n.getIdNegocio(),n.getNombre(),n.getDireccion(),n.getLocalidad(),n.getTelefono());
    }

    public Negocio modelToEntity(NegocioModel n){
        return new Negocio(n.getNombre(),n.getDireccion(),n.getLocalidad(),n.getTelefono());
    }
    
}
