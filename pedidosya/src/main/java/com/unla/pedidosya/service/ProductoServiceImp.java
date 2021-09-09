package com.unla.pedidosya.service;

import java.util.ArrayList;
import java.util.List;

import com.unla.pedidosya.converter.ProductoConverter;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImp implements IProductoService{

    @Autowired
    private IProductoRepository producto;

    @Autowired
    private ProductoConverter converter;
    
    public List<ProductoModel> getAll(){
        List<ProductoModel> lista = new ArrayList<ProductoModel>();
        for(Producto p : producto.findAll()){
            //uso la clase converter para pasar de una entidad de la base de datos a un modelo
            lista.add(converter.entityToModel(p));
        }
        return lista;
    }


    //metodo para filtrar por tipo los productos
    public List<ProductoModel> listaProductosPorTipo(String tipo) {
        List<ProductoModel> productos = new ArrayList<ProductoModel>();
        for(Producto p : producto.findByTipo(tipo)){
            
            productos.add(converter.entityToModel(p));
        
        }
        return productos;
    }

    //metodo para filtrar productos por id del Negocio
    public List<ProductoModel> listaProductosPorIdNegocio(long idNegocio) {
        List<ProductoModel> productos = new ArrayList<ProductoModel>();
        for(Producto p : producto.findByidNegocio(idNegocio)){
            
            productos.add(converter.entityToModel(p));
    
        }
        return productos;
    }

    @Transactional
    public ProductoModel insertOrUpdate(ProductoModel model){
        producto.save(converter.modelToEntity(model));
        return model;
    }


    //esta mal
    @Transactional(readOnly = true)
    public ProductoModel encontrar(ProductoModel model){
        return converter.entityToModel(producto.findById(model.getNegocio().getIdNegocio()).orElse(null));
    }
    
}
