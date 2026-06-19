package com.turnos.turnos_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnos.turnos_app.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}

