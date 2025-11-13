package com.sena.clara.controller;

import com.sena.clara.dto.UsuarioRequestDTO;
import com.sena.clara.dto.UsuarioResponseDTO;
import com.sena.clara.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios/")
public class UsuarioController {
    private final UsuarioService usuarioService;

    //crear usuario
    @PostMapping("crear")
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO response = usuarioService.crearUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //buscar un solo usuario por su id
@GetMapping("{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id) {
        UsuarioResponseDTO response = usuarioService.obtenerUsuarioPorId(id);
    
        if (response != null) {
    
            return ResponseEntity.ok(response);
        } else {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 
    }
      @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    }
