package com.unla.pedidosya.repository;

import com.unla.pedidosya.entity.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles,Long>{

    

}
