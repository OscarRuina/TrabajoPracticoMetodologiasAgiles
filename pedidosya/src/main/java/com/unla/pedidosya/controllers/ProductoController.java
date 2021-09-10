package com.unla.pedidosya.controllers;

import java.util.List;

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

@Controller
public class ProductoController {

    @Autowired
    private ProductoServiceImp producto;

    @Autowired
    private NegocioServiceImp negocio;

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
    public String porductosALL(Model model) {
        
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
    
}