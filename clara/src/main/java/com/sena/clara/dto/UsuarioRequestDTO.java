package com.sena.clara.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
    @Size(min = 3, max = 30)
    private String nombre;

    @Min(18)
    @Max(100)
    private Integer edad;

    @Email
    private String correo;
}