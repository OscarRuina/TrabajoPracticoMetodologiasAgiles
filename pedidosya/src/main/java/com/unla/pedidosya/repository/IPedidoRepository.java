package com.unla.pedidosya.repository;

import java.util.List;

import com.unla.pedidosya.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long> {

    // para buscar strings usar like + el formato %:atributo% aca es el nombre
    // completo
    @Query(value = "select * from Pedido p inner join item_pedido ip on p.id_pedido=ip.id_pedido where p.comprador like %:comprador%", nativeQuery = true)
    public List<Pedido> findByUser(@Param("comprador") String comprador);
}
