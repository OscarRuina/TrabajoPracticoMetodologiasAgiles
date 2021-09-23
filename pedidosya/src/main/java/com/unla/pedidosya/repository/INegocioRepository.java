package com.unla.pedidosya.repository;

//import java.io.Serializable;
import java.util.List;

import com.unla.pedidosya.entity.Negocio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface INegocioRepository extends JpaRepository<Negocio,Long> {
    
    // para buscar strings usar like + el formato %:atributo%
    @Query(value = "select * from Negocio n where n.localidad like %:localidad%",nativeQuery = true)
    public List<Negocio> findByLocalidad(@Param("localidad")String localidad);
    
    // para buscar strings usar like + el formato %:atributo% no funciona el ignore case osea sin importar mayusculas
    /*@Query("select * from Negocio n where upper(n.localidad) like upper(%?1%)")
    List<Negocio> findByLocalidadIgnoreCase(String localidad);*/
    
}
