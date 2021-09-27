package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.CarritoModel;
import com.unla.pedidosya.repository.IProductoRepository;
import com.unla.pedidosya.converter.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarritoController {
    
    @Autowired
    private IProductoRepository repo;

    @Autowired
    private ProductoConverter converter;

    /* no se que hago */
    CarritoModel carrito = new CarritoModel();

    @GetMapping("/agregarCarrito/{idProducto}")
    public String agregarCarrito(@PathVariable(name = "idProducto") long idProducto, Model model){
        try{
 
            carrito.agregarProducto(converter.entityToModel(repo.findById(idProducto).get()));
            carrito.setPrecioTotal();
            model.addAttribute("carrito", carrito);
            
        }catch(Exception e){
            e.getMessage();
        }
        return ViewRouteHelper.CARRITO;
    }

    @GetMapping("irAlCarrito/{}")
    public String irAlCarrito(Model model){
        model.addAttribute("carrito", carrito);
        return ViewRouteHelper.CARRITO;
    }
}
