package com.unla.pedidosya.service;

import com.unla.pedidosya.converter.ProductoConverter;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.repository.INegocioRepository;
import com.unla.pedidosya.repository.IProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    private IProductoRepository producto;

    @Autowired
    private INegocioRepository negocio;

    @Autowired
    private ProductoConverter converter;

    @Transactional(readOnly = true)
    public List<Producto> getAll() {
        return producto.findAll();
    }

    @Transactional(readOnly = true)
    public Producto getById(long id) {
        return producto.getById(id);
    }

    //metodo para filtrar por localidad los negocios
    @Transactional(readOnly = true)
    public List<Producto> listaProductosPorTipo(String tipo) {
        return producto.findByTipo(tipo);
    }

    @Transactional
    public Producto insertOrUpdate(Producto model) {
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

        return this.producto.findById(id);
    }


    @Override
    @Transactional
    public Producto save(Producto negocio) {

        return this.producto.saveAndFlush(negocio);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Producto> findAll() {

        return this.producto.findAll();
    }


    @Override
    @Transactional
    public void deleteById(long id) {

        this.producto.deleteById(id);
    }

    @Transactional(readOnly = true)
    public ProductoModel encontrar(ProductoModel model) {
        Optional<Producto> entity = producto.findById(model.getIdProducto());
        /*Producto entity = producto.getById(model.getIdProducto());*/
        ProductoModel entityToModel = converter.entityToModel(entity.get());
        return entityToModel;
    }

}
