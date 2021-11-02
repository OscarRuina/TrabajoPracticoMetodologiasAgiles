package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.service.NegocioServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RepartidorController {

    @Autowired
    private NegocioServiceImp negocio;

    @GetMapping("/pedidosRepartidor")
    public String pedidosRepartidor(String localidad,Model model){
        model.addAttribute("listaLocalidad", negocio.findByLocalidad(localidad));
        return ViewRouteHelper.LISTAPEDIDOS;
    }

    @GetMapping("/busquedaRepartidor")
    public String busquedaRepartidor(){
        return ViewRouteHelper.BUSQUEDAPEDIDOS;
    }


    
}
