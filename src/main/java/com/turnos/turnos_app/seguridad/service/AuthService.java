package com.turnos.turnos_app.seguridad.service;

import org.springframework.stereotype.Service;

import com.turnos.turnos_app.seguridad.model.Usuario;
import com.turnos.turnos_app.seguridad.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario login(String username, String password) {

        Usuario user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return user;
    }
}
