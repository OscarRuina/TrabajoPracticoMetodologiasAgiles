package com.unla.pedidosya.controllers;

import com.unla.pedidosya.helpers.ViewRouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("")
    public String index() {
        return ViewRouteHelper.INDEX;
    }

}
