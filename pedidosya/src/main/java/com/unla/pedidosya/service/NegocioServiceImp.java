package com.unla.pedidosya.service;

import com.unla.pedidosya.converter.NegocioConverter;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.repository.INegocioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NegocioServiceImp implements INegocioService {

    @Autowired
    private INegocioRepository negocio;

    @Autowired
    private NegocioConverter converter;

    @Transactional(readOnly = true)
    public List<Negocio> getAll() {
        return negocio.findAll();
    }

    @Transactional(readOnly = true)
    public Negocio getById(long id) {
        return negocio.getById(id);
    }

    // metodo para filtrar por localidad los negocios
    @Transactional(readOnly = true)
    public List<Negocio> listaNegocioPorZona(String localidad) {
        /* return negocio.findByLocalidad(localidad); */
        return negocio.findByLocalidad(localidad);
    }

    @Transactional
    public Negocio insertOrUpdate(Negocio model) {
        negocio.save(model);
        return model;

    }

    @Transactional(readOnly = true)
    public NegocioModel encontrar(NegocioModel model) {
        Negocio entity = negocio.getById(model.getIdNegocio());
        NegocioModel entityToModel = converter.entityToModel(entity);
        return entityToModel;
    }

    /* los que se agregaron porque se deben implementar por el INegocioService */
    @Override
    @Transactional(readOnly = true)
    public Optional<Negocio> findById(long id) {

        return this.negocio.findById(id);
    }

    @Override
    @Transactional
    public Negocio save(Negocio negocio) {

        return this.negocio.saveAndFlush(negocio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Negocio> findAll() {

        return this.negocio.findAll();
    }

    @Override
    @Transactional
    public void deleteById(long id) {

        this.negocio.deleteById(id);
    }

    @Transactional
    public List<Pedido> findByLocalidad(String localidad) {
        List<Negocio> n = negocio.findByLocalidad(localidad);
        List<Pedido> pedidos = new ArrayList<Pedido>();
        for (Negocio neg : n) {
            for (Pedido p : neg.getPedidos()) {
                if (p.isListo()) {
                    pedidos.add(p);
                }
            }
        }
        return pedidos;
    }

    /*
     * @Transactional public List<Pedido> findByLocalidad(String localidad){
     * List<Negocio> n = negocio.findByLocalidad(localidad); List<Pedido> pedidos =
     * new ArrayList<Pedido>(); for(Negocio neg: n){ for(Pedido p :
     * neg.getPedidos()){ if(p.isListo()){ pedidos.add(p); } } } return pedidos; }
     */

}
