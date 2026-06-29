package com.turnos.turnos_app.seguridad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnos.turnos_app.seguridad.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
