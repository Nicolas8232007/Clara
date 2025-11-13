package com.sena.clara.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String correo;
    private Integer edad;
}