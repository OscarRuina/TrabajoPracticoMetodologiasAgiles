package com.unla.pedidosya.service;

import com.unla.pedidosya.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private IPedidoRepository repo;


}
