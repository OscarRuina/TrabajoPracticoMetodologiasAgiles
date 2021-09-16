package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @PostMapping("/login_success")
    public String loginSuccess(){
        return ViewRouteHelper.INDEX;
    }

}
