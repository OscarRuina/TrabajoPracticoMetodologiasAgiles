package com.unla.pedidosya.service;

import java.util.List;
import java.util.Optional;

import com.unla.pedidosya.converter.PedidoConverter;
import com.unla.pedidosya.entity.Pedido;
import com.unla.pedidosya.model.PedidoModel;
import com.unla.pedidosya.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private PedidoConverter converter;

    @Transactional
    public Pedido save(Pedido p) {
        // Negocio n = negRepo.findById(p.getNegocio().getIdNegocio()).get();
        // n.getPedidos().add(p);
        repo.save(p);
        // negRepo.save(n);
        return p;
    }

    // metodo para filtrar por pedidos por usuario
    @Transactional(readOnly = true)
    public List<Pedido> listaPedidosPorUsuario(String nombreCompleto) {
        return repo.findByUser(nombreCompleto);
    }

    @Transactional(readOnly = true)
    public PedidoModel encontrar(PedidoModel model) {
        Pedido entity = repo.getById(model.getIdPedido());
        PedidoModel entityToModel = converter.entityToModel(entity);
        return entityToModel;
    }

    @Transactional(readOnly = true)
    public Pedido getById(long id) {
        return repo.getById(id);
    }

    @Override
    public Optional<Pedido> findById(long id) {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }

    @Override
    public Iterable<Pedido> findAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);

    }

}
