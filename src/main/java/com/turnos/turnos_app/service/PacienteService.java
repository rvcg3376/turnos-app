package com.turnos.turnos_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turnos.EstadoRegistro;
import com.turnos.turnos_app.model.Paciente;
import com.turnos.turnos_app.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    PacienteService (PacienteRepository ps){
        this.pacienteRepository = ps;
    }

    @Transactional
    public Paciente guardar(Paciente d){
        d.setEstado(EstadoRegistro.ACTIVO);
        return pacienteRepository.save(d);
    }

    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }

    @Transactional
    public Paciente anular(Long id){
        Paciente d = pacienteRepository.findById(id).orElseThrow();
        d.setEstado(EstadoRegistro.ANULADO);
        return pacienteRepository.save(d);
    }

    @Transactional
    public Paciente actualizar(Paciente d){
        Paciente dx = pacienteRepository.findById(d.getId()).orElseThrow();
        dx.setIdentificacion(d.getIdentificacion());
        return pacienteRepository.save(dx);
    }


}
