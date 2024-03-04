package com.example.examenspringboot.model;

import jakarta.persistence.*;
import lombok.Data;
/*
 Nombre: Fernando Pérez de Ayala Blázquez
 Ciclo: 2ºDAM
 */
@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double total;

    private String estado;
}
