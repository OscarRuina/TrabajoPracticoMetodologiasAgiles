package com.unla.pedidosya.repository;

import com.unla.pedidosya.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
    
    public User findByUsername(String username);

}
