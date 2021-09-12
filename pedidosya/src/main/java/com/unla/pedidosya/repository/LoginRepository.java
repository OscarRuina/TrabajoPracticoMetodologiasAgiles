package com.unla.pedidosya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unla.pedidosya.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByUsernameAndPassword(String username, String password);
 
}
