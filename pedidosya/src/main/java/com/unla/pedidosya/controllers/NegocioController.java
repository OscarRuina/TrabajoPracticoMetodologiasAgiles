package com.unla.pedidosya.controllers;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.NegocioServiceImp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private IUserRepository repo;

    @GetMapping("negociosPorZona")
    public String negociosPorZona(String localidad, Model model) {
        if (localidad != null) {
            model.addAttribute("listaLocalidad", negocio.listaNegocioPorZona(localidad));
        } else {
            model.addAttribute("listaLocalidad", negocio.getAll());
        }
        return ViewRouteHelper.LISTAZONA;
    }

    @GetMapping("/irAlFormulario")
    public String irAlFormulario(Model model) {
        List<User> vendedores = repo.findAll();
        Negocio n = new Negocio();
        model.addAttribute("negocio", n);
        model.addAttribute("vendedores", vendedores);
        return ViewRouteHelper.FORMULARIO;
    }

    @RequestMapping("/altaNegocio")
    public String altaNegocio(@ModelAttribute("negocio") Negocio model,
            HttpServletRequest request) {
        Negocio save = model;
        String username = request.getRemoteUser();
        User u = repo.findByUsername(username);
        u.getNegocios().add(save);
        save.setVendedor(u);
        negocio.insertOrUpdate(save);
        repo.save(u);
        return ViewRouteHelper.ALTANEGOCIO;
    }

    @GetMapping("/informacion/{idNegocio}")
    public String informacion(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("entidad", n);
        //paso la lista
        Negocio neg = negocio.getById(n.getIdNegocio());
        model.addAttribute("productos", neg.getProductos());
        
        System.out.println("Estado "+ model.getAttribute("estado"));
        return ViewRouteHelper.INFO;
    }

    @GetMapping("/misproductos/{idNegocio}")
    public String misProductos(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("entidad", n);
        //paso la lista
        Negocio neg = negocio.getById(n.getIdNegocio());
        model.addAttribute("productos", neg.getProductos());
        return ViewRouteHelper.MISPRODUCTOS;
    }

    @GetMapping("/negocios")
    public String negocios(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        model.addAttribute("negocios", repo.findByUsername(username).getNegocios());
        return ViewRouteHelper.MISNEGOCIOS;
    }

}
