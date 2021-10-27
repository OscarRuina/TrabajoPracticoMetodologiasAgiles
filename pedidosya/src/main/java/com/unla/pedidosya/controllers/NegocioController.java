package com.unla.pedidosya.controllers;

import com.unla.pedidosya.converter.NegocioConverter;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.repository.IPedidoRepository;
import com.unla.pedidosya.repository.IProductoRepository;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.NegocioServiceImp;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NegocioController {

    NegocioModel negAModif = new NegocioModel();
    @Autowired
    private NegocioServiceImp negocio;

    @Autowired
    private IPedidoRepository pedidoR;

    @Autowired
    private IProductoRepository productoR;

    @Autowired
    private IUserRepository repo;

    @Autowired
    private NegocioConverter negocioC;

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
    public String altaNegocio(@ModelAttribute("negocio") Negocio model, HttpServletRequest request, Model m) {
        Negocio save = model;
        String username = request.getRemoteUser();
        User u = repo.findByUsername(username);
        u.getNegocios().add(save);
        save.setVendedor(u);
        negocio.insertOrUpdate(save);
        repo.save(u);
        m.addAttribute("estado", "EXITO");
        m.addAttribute("mensaje", "Negocio agregado correctamente");
        return negocios(request, m);
        /* return ViewRouteHelper.ALTANEGOCIO; */
    }

    @GetMapping("/informacion/{idNegocio}")
    public String informacion(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("entidad", n);
        // paso la lista
        Negocio neg = negocio.getById(n.getIdNegocio());
        model.addAttribute("productos", productoR.findByNegocio(neg.getIdNegocio()));
        System.out.println(neg.toString());
        System.out.println(n.toString());
        return ViewRouteHelper.INFO;
    }

    @GetMapping("/misproductos/{idNegocio}")
    public String misProductos(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("entidad", n);
        // paso la lista
        Negocio neg = negocio.getById(n.getIdNegocio());
        // model.addAttribute("productos", neg.getProductos());
        model.addAttribute("productos", productoR.findByNegocio(neg.getIdNegocio()));
        System.out.println("Si contiene estado: " + model.containsAttribute("estado"));

        return ViewRouteHelper.MISPRODUCTOS;
    }

    /*
     * @GetMapping("/mispedidosrecibidos/{idNegocio}") public String
     * misPedidosRecibidos(NegocioModel n, Model model) { n = negocio.encontrar(n);
     * model.addAttribute("negocio", n); Negocio neg =
     * negocio.getById(n.getIdNegocio()); List<Pedido> pedidos =
     * pedidoR.findByNegocio(n.getIdNegocio()); model.addAttribute("pedidos",
     * pedidos); return ViewRouteHelper.MISPEDIDOS; }
     */

    @GetMapping("/mispedidosrecibidos/{idNegocio}")
    public String misPedidosRecibidos(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("negocio", n);
        Negocio neg = negocio.getById(n.getIdNegocio());
        List<Pedido> pedidos = pedidoR.findByNegocioRecibidos(n.getIdNegocio());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("tipoPedido", "recibidos");
        return ViewRouteHelper.MISPEDIDOS;
    }

    @GetMapping("/mispedidosentregados/{idNegocio}")
    public String misPedidosEntregados(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("negocio", n);
        Negocio neg = negocio.getById(n.getIdNegocio());
        List<Pedido> pedidos = pedidoR.findByNegocioEntregados(n.getIdNegocio());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("tipoPedido", "entregados");
        return ViewRouteHelper.MISPEDIDOS;
    }

    @GetMapping("/mispedidoscompletados/{idNegocio}")
    public String misPedidosCompletados(NegocioModel n, Model model) {
        n = negocio.encontrar(n);
        model.addAttribute("negocio", n);
        Negocio neg = negocio.getById(n.getIdNegocio());
        List<Pedido> pedidos = pedidoR.findByNegocioCompletados(n.getIdNegocio());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("tipoPedido", "completados");
        return ViewRouteHelper.MISPEDIDOS;
    }

    @GetMapping("/negocios")
    public String negocios(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        model.addAttribute("negocios", repo.findByUsername(username).getNegocios());
        return ViewRouteHelper.MISNEGOCIOS;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/editarNegocio/{idNegocio}")
    public String editarNegocio(@PathVariable(name = "idNegocio") long idNegocio, Model model) {
        NegocioModel n = negocioC.entityToModel(negocio.findById(idNegocio).get());
        negAModif = n;
        model.addAttribute("entidad", n);

        model.addAttribute("user", n.getVendedor());

        return ViewRouteHelper.EDITARNEGOCIO;
    }

    @PostMapping("/negocio/modif")
    public String modifNegocio(@ModelAttribute("producto") Negocio model, Model m, HttpServletRequest request) {
        model.setIdNegocio(negAModif.getIdNegocio());
        model.setVendedor(negAModif.getVendedor());

        Negocio save = model;
        negocio.save(save);

        m.addAttribute("estado", "EXITO");
        m.addAttribute("mensaje", "Negocio modificado correctamente");

        return negocios(request, m);

    }

}
