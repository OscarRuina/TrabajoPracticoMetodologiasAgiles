package com.unla.pedidosya.controllers;

import com.unla.pedidosya.service.PedidoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PedidoController {

    @Autowired
    private PedidoServiceImp service;


}
