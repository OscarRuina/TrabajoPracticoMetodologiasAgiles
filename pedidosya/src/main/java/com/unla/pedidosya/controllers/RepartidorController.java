package com.unla.pedidosya.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.repository.IPedidoRepository;
import com.unla.pedidosya.repository.IUserRepository;
import com.unla.pedidosya.service.NegocioServiceImp;
import com.unla.pedidosya.service.PedidoServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RepartidorController {

    @Autowired
    private NegocioServiceImp negocio;

    @Autowired
    private PedidoServiceImp pedidoS;

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private IPedidoRepository pedidoR;

    /*
     * @GetMapping("/pedidosRepartidor") public String pedidosRepartidor(String
     * localidad,Model model){ model.addAttribute("listaLocalidad",
     * negocio.findByLocalidad(localidad)); return ViewRouteHelper.LISTAPEDIDOS; }
     */
    @GetMapping("/pedidosRepartidor")
    public String pedidosRepartidor(String localidad, Model model) {
        model.addAttribute("pedidos", pedidoS.findPedidosByLocalidad(localidad));
        return ViewRouteHelper.LISTAPEDIDOS;
    }

    @GetMapping("/busquedaRepartidor")
    public String busquedaRepartidor() {
        return ViewRouteHelper.BUSQUEDAPEDIDOS;
    }

    @GetMapping("/misPedidosEntregadosR")
    public String misPedidosEntregadosR(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        User u = userRepo.findByUsername(username);

        model.addAttribute("user", u);

        List<Pedido> pedidos = pedidoR.findByRepartidor(u.getIdUser());

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("tipoPedido", "completados");
        return ViewRouteHelper.MISPEDIDOSENTREGADOSR;
    }

}
