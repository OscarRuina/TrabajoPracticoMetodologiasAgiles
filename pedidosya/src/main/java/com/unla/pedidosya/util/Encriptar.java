package com.unla.pedidosya.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    // Ya no es necesario, anda el registro
    /*
    public static void main(String[] args) {
        /*Correr este metodo para encriptar contraseñas, y ponerlas en el MySQL
        Primero insertar los roles ROLE_REPARTIDOR ROLE_VENDEDOR ROLE_COMPRADOR
        Segundo insertar los usuarios, username, password(encriptado), y enabled(Poner TRUE en MySQL, no pregunten porque pero funciona)
        Tercero insertar en la tabla intermedia entre user y roles los id para relacionar las tablas
        Al iniciar el server vs code les pregunta si que quieren correr, esta clase o la pedidosyaApplication, la segunda
        System.out.println("Contraseña 1234 encriptada es: " + passwordEncoder().encode("1234")); 
        

    }*/

    public static BCryptPasswordEncoder passwordEncoder(){
        //el numero va de 4 a 31, entre mas alto mejor la encriptacion
        return new BCryptPasswordEncoder(7);
    }
    
}
