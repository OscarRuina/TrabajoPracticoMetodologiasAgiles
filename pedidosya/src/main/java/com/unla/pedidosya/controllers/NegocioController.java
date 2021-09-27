package com.unla.pedidosya.controllers;

import java.util.List;

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
        List<User> vendedores = repo.findAll();
        Negocio n = new Negocio();
        model.addAttribute("negocio", n);
        model.addAttribute("vendedores", vendedores);
        return ViewRouteHelper.FORMULARIO;
    }

    @RequestMapping("/altaNegocio")
    public String altaNegocio(@ModelAttribute("negocio") Negocio model){
        Negocio save = model;
        negocio.insertOrUpdate(save);
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
    public String negocios(@PathVariable(name = "username")String username, Model model){
        //aca no anda
        model.addAttribute("entidad",repo.findByUsername(username).getNegocios());
        return ViewRouteHelper.MISNEGOCIOS;
    }
    
}
