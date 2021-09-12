package com.unla.pedidosya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.unla.pedidosya.entity.Login;
import com.unla.pedidosya.repository.LoginRepository;
 
 
 
@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
  
  public Login login(String username, String password) {
	  Login user = repo.findByUsernameAndPassword(username, password);
  	return user;
  }
	
 
}