package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarritoController {
    
    @Autowired
    private IProductoRepository repo;

    @GetMapping("/agregarCarrito/{idProducto}")
    public String agregarCarrito(@PathVariable(name = "idProducto") long idProducto,Model model){
        try{
            model.addAttribute("carrito", repo.findById(idProducto).get());
        }catch(Exception e){
            e.getMessage();
        }
        return ViewRouteHelper.CARRITO;
    }
}