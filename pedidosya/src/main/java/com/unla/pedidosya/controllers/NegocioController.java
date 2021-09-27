package com.unla.pedidosya.controllers;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.NegocioServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NegocioController {

    @Autowired
    private NegocioServiceImp negocio;

    @Autowired
    private IUserRepository repo;

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

    @GetMapping("irAlFormulario/")
    public String irAlFormulario(Model model){
        Negocio n = new Negocio();
        model.addAttribute("negocio", n);
        return ViewRouteHelper.FORMULARIO;
    }

    @RequestMapping("/altaNegocio/{username}")
    public String altaNegocio(@ModelAttribute("negocio") Negocio model,@PathVariable(name = "username") String username){
        User u = repo.findByUsername(username);
        u.getNegocios().add(model);
        model.setVendedor(u);
        negocio.insertOrUpdate(model);
        return ViewRouteHelper.ALTANEGOCIO;
    }

    @GetMapping("/informacion/{idNegocio}")
    public String informacion(NegocioModel n, Model model){
        n = negocio.encontrar(n);
        model.addAttribute("entidad", n);
        //paso la lista
        Negocio neg = negocio.getById(n.getIdNegocio());
        model.addAttribute("productos", neg.getProductos());
        return ViewRouteHelper.INFO; 
    }

    @GetMapping("/negocios/{username}")
    public String negocios(@PathVariable(name = "username") String username,Model model){
        /* busco el user por username
        agrego al modelo la lista de negocios
        retorno la lista de negocios*/
        User u = repo.findByUsername(username);
        model.addAttribute("entidad", u.getNegocios());
        return ViewRouteHelper.MISNEGOCIOS;
    }
    
}
