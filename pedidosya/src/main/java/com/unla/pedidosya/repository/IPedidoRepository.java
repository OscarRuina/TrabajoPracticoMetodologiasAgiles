package com.unla.pedidosya.repository;

import java.util.List;

import com.unla.pedidosya.entity.ItemPedido;
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

    // busco todos los pedidos por el idNegocio
    @Query(value = "select * from Pedido p where p.id_negocio like %:id_negocio%", nativeQuery = true)
    public List<Pedido> findByNegocio(@Param("id_negocio") Long id_negocio);

    // busco todos los pedidos por el idNegocio con listo = 0
    @Query(value = "select * from Pedido p where p.id_negocio like %:id_negocio% and listo=false", nativeQuery = true)
    public List<Pedido> findByNegocioRecibidos(@Param("id_negocio") Long id_negocio);

    // busco todos los pedidos por el idNegocio con listo = 1 y entregado=0
    @Query(value = "select * from Pedido p where p.id_negocio like %:id_negocio% and listo=true and entregado=false", nativeQuery = true)
    public List<Pedido> findByNegocioCompletados(@Param("id_negocio") Long id_negocio);

    // busco todos los pedidos por el idNegocio con listo=1 y entregado=1
    @Query(value = "select * from Pedido p where p.id_negocio like %:id_negocio% and listo=true and entregado=true", nativeQuery = true)
    public List<Pedido> findByNegocioEntregados(@Param("id_negocio") Long id_negocio);

    // pedidos listos por localidad
    @Query(value = "select * from Pedido p inner join Negocio n on p.id_negocio=n.id_negocio where n.localidad like %:localidad% and p.listo=true and p.en_camino=false", nativeQuery = true)
    public List<Pedido> findPedidosByLocalidad(@Param("localidad") String localidad);

    // pedidos listos por localidad
    @Query(value = "select * from Item_pedido ip where ip.id_pedido like %:id_pedido%", nativeQuery = true)
    public List<ItemPedido> findItems(@Param("id_pedido") long id_pedido);

    @Query(value = "select * from Pedido p where p.repartidor like %:idUser% and entregado=true", nativeQuery = true)
    public List<Pedido> findByRepartidor(long idUser);
}
