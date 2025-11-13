package com.sena.clara.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity //Bean semántico (se instancia una sola vez) (Singleton)
@Data // Getters y Setters
@Table(name = "usuarios") // Nombre de la tabla
public class Usuario {
    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;

    @Column(nullable = false) // Se permiten nulos? = false
    private String nombre;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private String correo;
}