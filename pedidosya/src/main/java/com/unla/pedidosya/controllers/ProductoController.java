package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.service.ProductoServiceImp;
import com.unla.pedidosya.service.NegocioServiceImp;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.model.NegocioModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String productosALL(Model model) {
        
        model.addAttribute("listaTipo", producto.getAll());
        
        return ViewRouteHelper.LISTATIPOCOMIDA;
    }


    @GetMapping("darAltaProducto")
    public String darAltaProducto(Model model){
        List<NegocioModel> listaNegocios = negocio.getAll();
        ProductoModel p = new ProductoModel();
        model.addAttribute("producto", p);
        model.addAttribute("listaNegocios", listaNegocios);
        return ViewRouteHelper.DARALTAPRODUCTO;
    }

    @RequestMapping("/altaProducto")
    public String altaNegocio(@ModelAttribute("producto") ProductoModel model){
        producto.insertOrUpdate(model);
        return ViewRouteHelper.ALTAPRODUCTO;
    }
    
}