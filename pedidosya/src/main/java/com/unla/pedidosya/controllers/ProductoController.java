package com.unla.pedidosya.controllers;

import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.NegocioServiceImp;
import com.unla.pedidosya.service.ProductoServiceImp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    @Autowired
    private ProductoServiceImp producto;

    @Autowired
    private NegocioServiceImp negocio;

    @Autowired
    private IUserRepository repo;

    @GetMapping("productosPorTipo")
    public String productosPorTipo(String tipo, Model model) {
        if (tipo != null) {
            model.addAttribute("listaTipo", producto.listaProductosPorTipo(tipo));
        } else {
            model.addAttribute("listaTipo", producto.getAll());
        }
        return ViewRouteHelper.LISTATIPOCOMIDA;
    }

    @GetMapping("productosALL")
    public String porductosALL(Model model) {

        model.addAttribute("listaTipo", producto.getAll());

        return ViewRouteHelper.LISTATIPOCOMIDA;
    }

    @GetMapping("/producto/new")
    public String formularioProducto(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        model.addAttribute("producto", new ProductoModel());
        model.addAttribute("negocios", repo.findByUsername(username).getNegocios());
        return ViewRouteHelper.FORMULARIOPRODUCTO;
    }

    @PostMapping("/producto/save")
    public String altaProducto(@ModelAttribute("producto") Producto model) {
        producto.insertOrUpdate(model);
        return ViewRouteHelper.ALTAPRODUCTO;
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificar(@PathVariable(name = "idProducto") long idProducto, Model model) {
        model.addAttribute("producto", producto.findById(idProducto));
        Negocio n = producto.findById(idProducto).get().getNegocio();
        model.addAttribute("negocios", n);
        return ViewRouteHelper.FORMULARIOPRODUCTO;
    }

}
