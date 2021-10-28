package com.unla.pedidosya.controllers;

import com.unla.pedidosya.converter.NegocioConverter;
import com.unla.pedidosya.converter.ProductoConverter;
import com.unla.pedidosya.entity.Producto;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.NegocioModel;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.NegocioServiceImp;
import com.unla.pedidosya.service.ProductoServiceImp;

import java.io.Console;
import java.util.Optional;

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

    ProductoModel prodAModif = new ProductoModel();
    @Autowired
    private ProductoServiceImp producto;
    @Autowired
    private NegocioServiceImp negocio;
    @Autowired
    private ProductoConverter converter;
    @Autowired
    private IUserRepository repo;
    @Autowired
    private NegocioController negocioController;
    @Autowired
    private NegocioConverter negocioConverter;

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
    public String productosALL(Model model) {

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
    public String altaProducto(@ModelAttribute("producto") Producto m, Model model) {
        producto.insertOrUpdate(m);
        model.addAttribute("estado", "EXITO");
        model.addAttribute("mensaje", "Producto agregado correctamente");
        return negocioController.misProductos(negocioConverter.entityToModel(m.getNegocio()), model);
        /* return ViewRouteHelper.ALTAPRODUCTO; */
    }

    @PostMapping("/producto/modif")
    public String modifProducto(@ModelAttribute("producto") Producto model, Model m) {
        model.setIdProducto(prodAModif.getIdProducto());
        model.getNegocio().setIdNegocio(prodAModif.getNegocio().getIdNegocio());
        model.getNegocio().setVendedor(prodAModif.getNegocio().getVendedor());
        Producto save = model;
        producto.insertOrUpdate(save);
        m.addAttribute("estado", "EXITO");
        m.addAttribute("mensaje", "Producto modificado correctamente");
        ProductoModel p = converter.entityToModel(producto.findById(model.getIdProducto()).get());
        NegocioModel neg = negocio.encontrar(p.getNegocio());
        System.out.println(neg.toString());

        return negocioController.misProductos(neg, m);

    }

    /**
     * Returns the viewName to return for coming back to the sender url
     *
     * @param request Instance of {@link HttpServletRequest} or use an injected
     *                instance
     * @return Optional with the view name. Recomended to use an alternativa url
     *         with {@link Optional#orElse(Java.lang.Object)}
     */
    protected Optional<String> getPreviousPageByRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }

    @GetMapping("/editarProducto/{idProducto}")
    public String editarProducto(@PathVariable(name = "idProducto") long idProducto, Model model) {
        ProductoModel p = converter.entityToModel(producto.findById(idProducto).get());
        prodAModif = p;
        model.addAttribute("entidad", p);
        /* model.addAttribute("producto", new ProductoModel()); */
        model.addAttribute("negocio", p.getNegocio());
        model.addAttribute("user", p.getNegocio().getVendedor());

        return ViewRouteHelper.EDITARPRODUCTO;
    }

    @GetMapping("/eliminarProducto/{idProducto}")
    public String eliminarProducto(@PathVariable(name = "idProducto") long idProducto, Model model) {
        ProductoModel p = converter.entityToModel(producto.findById(idProducto).get());
        repo.deleteById(p.getIdProducto());

        model.addAttribute("estado", "EXITO");
        model.addAttribute("mensaje", "Producto eliminado correctamente");
        return negocioController.misProductos(p.getNegocio(), model);
    }
    /*
     * @GetMapping("/modificar/{idProducto}") public String
     * modificar(@PathVariable(name = "idProducto") long idProducto, Model model) {
     * model.addAttribute("producto", producto.findById(idProducto)); Negocio n =
     * producto.findById(idProducto).get().getNegocio();
     * model.addAttribute("negocios", n); return ViewRouteHelper.FORMULARIOPRODUCTO;
     * }
     */
}
