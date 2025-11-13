package com.sena.clara.service;

import com.sena.clara.dto.UsuarioRequestDTO;
import com.sena.clara.dto.UsuarioResponseDTO;
import com.sena.clara.entity.Usuario;
import com.sena.clara.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO crearUsuario (UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setEdad(usuarioRequestDTO.getEdad());
        usuario.setCorreo(usuarioRequestDTO.getCorreo());

        usuarioRepository.save(usuario);

        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setEdad(usuario.getEdad());
        response.setCorreo(usuario.getCorreo());

        return response;
    }

     public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            UsuarioResponseDTO response = new UsuarioResponseDTO();
            response.setId(usuario.getId());
            response.setNombre(usuario.getNombre());
            response.setEdad(usuario.getEdad());
            response.setCorreo(usuario.getCorreo());

            return response;
        } else {
            return null; 
    }
}
     
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
}
}