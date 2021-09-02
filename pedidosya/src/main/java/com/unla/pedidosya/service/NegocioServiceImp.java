package com.unla.pedidosya.service;

import java.util.ArrayList;
import java.util.List;

import com.unla.pedidosya.converter.NegocioConverter;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.repository.INegocioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegocioServiceImp implements INegocioService{

    @Autowired
    private INegocioRepository negocio;

    @Autowired
    private NegocioConverter converter;
    
    public List<NegocioModel> getAll(){
        List<NegocioModel> lista = new ArrayList<NegocioModel>();
        for(Negocio n : negocio.findAll()){
            //uso la clase converter para pasar de una entidad de la base de datos a un modelo
            lista.add(converter.entityToModel(n));
        }
        return lista;
    }


    //metodo para filtrar por localidad los negocios
    public List<NegocioModel> listaNegocioPorZona(String localidad) {
        List<NegocioModel> negocios = new ArrayList<NegocioModel>();
        for(Negocio n : negocio.findByLocalidad(localidad)){
            
            negocios.add(converter.entityToModel(n));
        
        }
        return negocios;
    }
    
}