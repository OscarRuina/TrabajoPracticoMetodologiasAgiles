package com.unla.pedidosya.service;

import java.util.List;
import com.unla.pedidosya.entity.Negocio;
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
        //Negocio n = negRepo.findById(p.getNegocio().getIdNegocio()).get();
        //n.getPedidos().add(p);
        repo.save(p);
        //negRepo.save(n);
        return p;
    }

    // metodo para filtrar por pedidos por usuario
    @Transactional(readOnly = true)
    public List<Pedido> listaPedidosPorUsuario(String nombreCompleto) {
        return repo.findByUser(nombreCompleto);
    }

}
