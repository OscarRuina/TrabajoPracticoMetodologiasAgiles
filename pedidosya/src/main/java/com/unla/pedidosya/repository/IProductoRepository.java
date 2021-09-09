package com.unla.pedidosya.repository;

import java.io.Serializable;
import java.util.List;

import com.unla.pedidosya.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Serializable> {
    
    // para buscar strings usar like + el formato %:atributo%
    //Traer productos por tipo
    @Query(value = "select * from Producto p where p.tipo like %:tipo%",nativeQuery = true)
    public List<Producto> findByTipo(@Param("tipo")String tipo);

    // para buscar strings usar like + el formato %:atributo%
    //Traer productos por Negocio
    @Query(value = "select * from Producto p where p.idNegocio like %:idNegocio%",nativeQuery = true)
    public List<Producto> findByidNegocio(@Param("idNegocio")long idNegocio);

}
