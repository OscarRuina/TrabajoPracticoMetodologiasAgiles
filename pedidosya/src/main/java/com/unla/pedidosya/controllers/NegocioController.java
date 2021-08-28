package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.service.NegocioServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NegocioController {

    @Autowired
    private NegocioServiceImp negocio;

    @GetMapping("negociosPorZona")
    public String negociosPorZona(String localidad, Model model) {
        if(localidad != null){
            model.addAttribute("listaLocalidad", negocio.listaNegocioPorZona(localidad));
        }
        else{
            model.addAttribute("listaLocalidad", negocio.getAll());
        }
        return ViewRouteHelper.LISTAZONA;
    }
    
}
