package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.service.ProductoServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {

    @Autowired
    private ProductoServiceImp producto;

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

    
    
}