package com.unla.pedidosya.controllers;

import com.unla.pedidosya.converter.ProductoConverter;
import com.unla.pedidosya.entity.ItemPedido;
import com.unla.pedidosya.entity.Negocio;
import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.CarritoModel;
import com.unla.pedidosya.model.ProductoModel;
import com.unla.pedidosya.repository.INegocioRepository;
import com.unla.pedidosya.repository.IProductoRepository;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.PedidoServiceImp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarritoController {

    /* no se que hago */
    CarritoModel carrito = new CarritoModel();
    @Autowired
    private IProductoRepository repo;
    @Autowired
    private ProductoConverter converter;
    @Autowired
    private IUserRepository userRepo;
    @Autowired
    private PedidoServiceImp service;
    @Autowired
    private INegocioRepository negocioRepo;

    @GetMapping("/agregarCarrito/{idProducto}")
    public String agregarCarrito(@PathVariable(name = "idProducto") long idProducto, Model model) {
        try {

            carrito.agregarProducto(converter.entityToModel(repo.findById(idProducto).get()));
            carrito.setPrecioTotal();
            model.addAttribute("carrito", carrito);

        } catch (Exception e) {
            e.getMessage();
        }
        return ViewRouteHelper.CARRITO;
    }

    @GetMapping("irAlCarrito")
    public String irAlCarrito(Model model) {
        model.addAttribute("carrito", carrito);
        return ViewRouteHelper.CARRITO;
    }

    @GetMapping("carritoConfirmado")
    public String carritoConfirmado(HttpServletRequest request, Model model) {
        // recuperar los datos de carrito, los productos y el total
        String username = request.getRemoteUser();
        User u = userRepo.findByUsername(username);
        Pedido p = new Pedido();
        p.setNombre(u.getUsername());
        p.setDireccion(u.getDireccion());
        p.setTelefono(u.getTelefono());
        // set los productos
        List<ItemPedido> items = new ArrayList<>();
        int contador = 0;
        for (ProductoModel pro : carrito.getProductos()) {
            items.add(new ItemPedido(1, converter.modelToEntityID(pro), p));
            System.out.println("producto : " + contador + "es :" + pro.toString());
            contador += 1;
        }

        p.setItemsPedidos(items);
        p.setPrecioTotal(carrito.getPrecioTotal());

        // System.out.println(prods.size());
        // set el precio

        // System.out.println(carrito.getPrecioTotal());
        // set negocio ( de la lista de productos agarrar el primero y setear el id
        // negocio

        Negocio ng = negocioRepo
                .getById(carrito.getProductos().get(carrito.getProductos().size() - 1).getNegocio()
                        .getIdNegocio());
        /*
         * Negocio n = negocioRepo.findByDireccion(prods.get(prods.size() -
         * 1).getNegocio().getDireccion());
         */
        p.setNegocio(ng);
        ng.getPedidos().add(p);

        System.out.println("pedido : " + p.toString());

        service.save(p);
        model.addAttribute("pedido", p);
        model.addAttribute("productos", p.getItemsPedidos());
        model.addAttribute("total", p.getPrecioTotal());
        /* Vacio el carrito una vez hecho el pedido */
        carrito = new CarritoModel();
        return ViewRouteHelper.COMPRA;
    }
}
