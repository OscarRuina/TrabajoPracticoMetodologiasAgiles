package com.unla.pedidosya.controllers;


import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.CarritoModel;
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
        CarritoModel carrito = new CarritoModel();
        try{
            Producto p = repo.findById(idProducto).get();
            carrito.getProductos().add(p);
            model.addAttribute("carrito", carrito);
        }catch(Exception e){
            e.getMessage();
        }
        return ViewRouteHelper.CARRITO;
    }
}
