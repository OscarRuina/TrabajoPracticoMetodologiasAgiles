package com.unla.pedidosya.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.model.PedidoModel;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.PedidoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {

    @Autowired
    private PedidoServiceImp serviceP;
    @Autowired
    private IUserRepository userRepo;
    @Autowired
    private NegocioController negcontroller;

    /*
     * @GetMapping("irAPedidos") public String irAPedidos(HttpServletRequest
     * request, Model model) { String username = request.getRemoteUser(); User u =
     * userRepo.findByUsername(username);
     * System.out.println(serviceP.listaPedidosPorUsuario(u.getNombre() + " " +
     * u.getApellido())); List<Pedido> pedidos =
     * serviceP.listaPedidosPorUsuario(u.getNombre() + " " + u.getApellido());
     * model.addAttribute("pedidos", pedidos); return
     * ViewRouteHelper.MISPEDIDOSUSER; }
     */

    @GetMapping("/irAPedidos")
    public String irAPedidos(HttpServletRequest request, String s, Model model) {
        String username = request.getRemoteUser();
        User u = userRepo.findByUsername(username);
        System.out.println(serviceP.listaPedidosPorUsuario(u.getNombre() + " " + u.getApellido()));
        List<Pedido> pedidos = serviceP.listaPedidosPorUsuario(u.getNombre() + " " + u.getApellido());
        model.addAttribute("pedidos", pedidos);
        return ViewRouteHelper.MISPEDIDOSUSER;
    }

    /*
     * @GetMapping("/irAPedidos/{tipoPedido}") public String
     * irAPedidos(HttpServletRequest request, String s, Model model) { String
     * username = request.getRemoteUser(); User u =
     * userRepo.findByUsername(username);
     * System.out.println(serviceP.listaPedidosPorUsuario(u.getNombre() + " " +
     * u.getApellido())); List<Pedido> pedidos =
     * serviceP.listaPedidosPorUsuario(u.getNombre() + " " + u.getApellido());
     * model.addAttribute("pedidos", pedidos); return
     * ViewRouteHelper.MISPEDIDOSUSER; }
     */

    @GetMapping("/marcarListo/{idPedido}")
    public String marcarListo(HttpServletRequest request, PedidoModel n, Model model) {
        n = serviceP.encontrar(n);
        model.addAttribute("entidad", n);
        // paso la lista
        Pedido ped = serviceP.getById(n.getIdPedido());
        ped.setListo(true);
        ped.setFechaListo(LocalDateTime.now());
        serviceP.save(ped);
        model.addAttribute("estado", "EXITO");
        model.addAttribute("mensaje", "Pedido marcado como Listo");
        return negcontroller.misPedidosRecibidos(n.getNegocio(), model);

    }

    @GetMapping("/marcarEnCamino/{idPedido}")
    public String marcarEnCamino(HttpServletRequest request, PedidoModel n, Model model) {
        String username = request.getRemoteUser();
        User u = userRepo.findByUsername(username);

        n = serviceP.encontrar(n);
        model.addAttribute("entidad", n);
        // paso la lista
        Pedido ped = serviceP.getById(n.getIdPedido());
        ped.setEnCamino(true);
        ped.setFechaEnCamino(LocalDateTime.now());
        ped.setrepartidor(u.getIdUser());
        serviceP.save(ped);
        model.addAttribute("estado", "EXITO");
        model.addAttribute("mensaje", "Pedido Seleccionado");
        model.addAttribute("pedido", ped);

        return ViewRouteHelper.PEDIDOAENTREGAR;
    }

    @GetMapping("/marcarEntregado/{idPedido}")
    public String marcarEntregado(HttpServletRequest request, PedidoModel n, Model model) {
        String username = request.getRemoteUser();
        User u = userRepo.findByUsername(username);

        n = serviceP.encontrar(n);
        model.addAttribute("entidad", n);
        // paso la lista
        Pedido ped = serviceP.getById(n.getIdPedido());
        ped.setEntregado(true);
        ped.setFechaEntregado(LocalDateTime.now());
        serviceP.save(ped);
        model.addAttribute("estado", "EXITO");
        model.addAttribute("mensaje", "Pedido Entregado");
        return ViewRouteHelper.BUSQUEDAPEDIDOS;
    }

}
