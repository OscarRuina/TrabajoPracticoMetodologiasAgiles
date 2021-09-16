package com.unla.pedidosya.service;

import com.unla.pedidosya.entity.User;
import com.unla.pedidosya.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private IUserRepository repo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private boolean checkUsernameAvailable(User user)throws Exception{
        User encontrado = repo.findByUsername(user.getUsername());
        if(encontrado != null){
            throw new Exception("Nombre de Usuario no diponible");
        }
        return true;
    }

    @Transactional
    public User save(User user) throws Exception{
        if(checkUsernameAvailable(user)){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(true);
            repo.save(user);
        }
        return user;
    }
    
}
