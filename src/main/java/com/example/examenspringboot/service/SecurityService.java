package com.example.examenspringboot.service;

import org.springframework.stereotype.Service;

/*
 Nombre: Fernando Pérez de Ayala Blázquez
 Ciclo: 2ºDAM
 */

@Service
public class SecurityService {
    public static Boolean validateToken(String token) {
        return (token.equals("t0k3n"));
    }
}
