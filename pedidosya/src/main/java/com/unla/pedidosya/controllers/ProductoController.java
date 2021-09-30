package com.unla.pedidosya.controllers;

import java.util.List;
import java.util.Optional;

import com.unla.pedidosya.converter.ProductoConverter;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.service.NegocioServiceImp;
import com.unla.pedidosya.service.ProductoServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductoController {

    @Autowired
    private ProductoServiceImp producto;

    @Autowired
    private NegocioServiceImp negocio;

    @Autowired
    private ProductoConverter converter;

    ProductoModel prodAModif = new ProductoModel();

    @GetMapping("productosPorTipo")
    public String productosPorTipo(String tipo, Model model) {
        if(tipo != null){
            model.addAttribute("listaTipo", producto.listaProductosPorTipo(tipo));
        }
        else{
            model.addAttribute("listaTipo", producto.getAll());
        }
        return ViewRouteHelper.LISTATIPOCOMIDA;
    }

    @GetMapping("productosALL")
    public String productosALL(Model model) {
        
        model.addAttribute("listaTipo", producto.getAll());
        
        return ViewRouteHelper.LISTATIPOCOMIDA;
    }

    @GetMapping("/producto/new")
    public String formularioProducto(Model model){
        List<Negocio> negocios = negocio.getAll();
        model.addAttribute("producto", new ProductoModel());
        model.addAttribute("negocios", negocios);
        return ViewRouteHelper.FORMULARIOPRODUCTO;
    }

    @PostMapping("/producto/save")
    public String altaProducto(@ModelAttribute("producto") Producto model){
        Producto save = model;
        producto.insertOrUpdate(save);
        return ViewRouteHelper.ALTAPRODUCTO;
    }
/* ESTE ES EL QUE ANDA
    @PostMapping("/producto/modif")
    public String modifProducto(@ModelAttribute("producto") Producto model){
        model.setIdProducto(prodAModif.getIdProducto());
        model.getNegocio().setIdNegocio(prodAModif.getNegocio().getIdNegocio());
        Producto save = model;
        producto.insertOrUpdate(save);
        return ViewRouteHelper.ALTAPRODUCTO;
    }*/

    @PostMapping("/producto/modif")
    public String modifProducto(@ModelAttribute("producto") Producto model, Model m){
        model.setIdProducto(prodAModif.getIdProducto());
        model.getNegocio().setIdNegocio(prodAModif.getNegocio().getIdNegocio());
        Producto save = model;
        producto.insertOrUpdate(save);
        m.addAttribute("estado", "EXITO");
        m.addAttribute("mensaje", "Producto modificado correctamente");
        return productosALL(m);
    }


    @GetMapping("/editarProducto/{idProducto}")
    public String editarProducto(@PathVariable(name = "idProducto") long idProducto, Model model){
        ProductoModel p = converter.entityToModel(producto.findById(idProducto).get());
        prodAModif = p;
        model.addAttribute("entidad", p);
        
        return ViewRouteHelper.EDITARPRODUCTO; 
    }
/*
    @GetMapping("/editarProducto/{idProducto}")
    public String editarProducto(ProductoModel p, Model model){
        p = producto.encontrar(p);
        model.addAttribute("entidad", p);
        return ViewRouteHelper.EDITARPRODUCTO; 
    }*/
    
}