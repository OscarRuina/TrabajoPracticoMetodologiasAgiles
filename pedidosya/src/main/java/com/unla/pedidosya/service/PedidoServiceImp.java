package com.unla.pedidosya.service;

import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.repository.INegocioRepository;
import com.unla.pedidosya.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private INegocioRepository negRepo;

    @Transactional
    public Pedido save(Pedido p) {
        // Negocio n = negRepo.findById(p.getNegocio().getIdNegocio()).get();
        // n.getPedidos().add(p);
        repo.save(p);
        //negRepo.save(n);
        return p;
    }


}
