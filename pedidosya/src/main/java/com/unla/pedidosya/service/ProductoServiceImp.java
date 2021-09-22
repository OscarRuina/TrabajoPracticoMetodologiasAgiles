package com.unla.pedidosya.service;

import java.util.List;
import java.util.Optional;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.repository.INegocioRepository;
import com.unla.pedidosya.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImp implements IProductoService{

    @Autowired
    private IProductoRepository producto;

    @Autowired
    private INegocioRepository negocio;

    @Transactional(readOnly = true)
    public List<Producto> getAll(){
        return producto.findAll();
    }
    
    //metodo para filtrar por localidad los negocios
    @Transactional(readOnly = true)
    public List<Producto> listaProductosPorTipo(String tipo) {
        return producto.findByTipo(tipo);
    }
    
    @Transactional
    public Producto insertOrUpdate(Producto model){
        //agregar este producto a un negocio
        Negocio n = negocio.findById(model.getNegocio().getIdNegocio()).get();
        n.getProductos().add(model);
        producto.save(model);
        negocio.save(n);
        return model;
    }



    /* los que se agregaron porque se deben implementar por el INegocioService */
    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(long id) {
        // TODO Auto-generated method stub
        return this.producto.findById(id);
    }


    @Override
    @Transactional
    public Producto save(Producto negocio) {
        // TODO Auto-generated method stub
        return this.producto.saveAndFlush(negocio);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Producto> findAll() {
        // TODO Auto-generated method stub
        return this.producto.findAll();
    }


    @Override
    @Transactional
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        this.producto.deleteById(id);
    }
    
}
