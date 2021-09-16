package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;
import com.unla.pedidosya.repository.IRolesRepository;
import com.unla.pedidosya.service.UserServiceImp;

import java.util.List;

import javax.validation.Valid;

import com.unla.pedidosya.entity.Roles;
import com.unla.pedidosya.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @Autowired
    private IRolesRepository repo;

    @Autowired
    private UserServiceImp service;

    @PostMapping("/login_success")
    public String loginSuccess(){
        return ViewRouteHelper.INDEX;
    }

    @GetMapping("/signup")
    public String signup(Model model){
        List<Roles> roles = repo.findAll();

        model.addAttribute("user", new User());
        model.addAttribute("role", roles);

        return ViewRouteHelper.REGISTRO;
    }

    @PostMapping("/signup")
    public String registrarUsuario(@Valid @ModelAttribute("user") User user,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("user", user);
        }
        else{
            try {
                //salvar
                service.save(user);
            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
            }
        }
        return ViewRouteHelper.INDEX;
    }

}
