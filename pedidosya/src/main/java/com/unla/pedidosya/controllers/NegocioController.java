package com.unla.pedidosya.controllers;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.service.NegocioServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("irAlFormulario")
    public String irAlFormulario(Model model){
        Negocio n = new Negocio();
        model.addAttribute("negocio", n);
        return ViewRouteHelper.FORMULARIO;
    }

    @RequestMapping("/altaNegocio")
    public String altaNegocio(@ModelAttribute("negocio") Negocio model){
        negocio.insertOrUpdate(model);
        return ViewRouteHelper.ALTANEGOCIO;
    }

    @GetMapping("/informacion/{idNegocio}")
    public String informacion(NegocioModel n, Model model){
        n = negocio.encontrar(n);
        model.addAttribute("entidad", n);
        return ViewRouteHelper.INFO; 
    }

    
}
