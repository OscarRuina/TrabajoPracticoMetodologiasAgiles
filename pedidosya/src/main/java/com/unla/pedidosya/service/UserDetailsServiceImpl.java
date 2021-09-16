package com.unla.pedidosya.service;

import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // busco al user por el nombre
        User user = repo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No se pudo encontrar el usuario");
        }
        return new MyUserDetails(user);
    }
    
}
