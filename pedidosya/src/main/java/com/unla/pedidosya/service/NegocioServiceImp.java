package com.unla.pedidosya.service;

import java.util.List;

import com.unla.pedidosya.converter.NegocioConverter;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.repository.INegocioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NegocioServiceImp implements INegocioService{

    @Autowired
    private INegocioRepository negocio;

    @Autowired
    private NegocioConverter converter;
    
    @Transactional(readOnly = true)
    public List<Negocio> getAll(){
        return negocio.findAll();
    }

    @Transactional(readOnly = true)
    public Negocio getById(long id){
        return negocio.getById(id);
    }

    //metodo para filtrar por localidad los negocios
    @Transactional(readOnly = true)
    public List<Negocio> listaNegocioPorZona(String localidad) {
        return negocio.findByLocalidad(localidad);
    }

    @Transactional
    public Negocio insertOrUpdate(Negocio model){
        negocio.save(model);
        return model;
    }

    @Transactional(readOnly = true)
    public NegocioModel encontrar(NegocioModel model){
        Negocio entity = negocio.getById(model.getIdNegocio());
        NegocioModel entityToModel = converter.entityToModel(entity);
        return entityToModel;
    }


}
