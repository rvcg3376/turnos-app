package com.turnos.turnos_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turnos.EstadoRegistro;
import com.turnos.turnos_app.model.Doctor;
import com.turnos.turnos_app.model.Paciente;
import com.turnos.turnos_app.model.Turno;
import com.turnos.turnos_app.repository.DoctorRepository;
import com.turnos.turnos_app.repository.PacienteRepository;
import com.turnos.turnos_app.repository.TurnoRepository;

import jakarta.transaction.Transactional;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;


    //  Inyección por constructor (mejor práctica)
    public TurnoService(TurnoRepository turnoRepository,
                        DoctorRepository doctorRepository,
                        PacienteRepository pacienteRepository) {
        this.turnoRepository = turnoRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    //  Crear turno
    @Transactional
    public Turno crearTurno(Long idDoctor, Long idPaciente, Turno turno) {

        Doctor doctor = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        turno.setId(null); //  asegura INSERT
        turno.setDoctor(doctor);
        turno.setPaciente(paciente);
        turno.setEstado(EstadoRegistro.ACTIVO);

        return turnoRepository.save(turno);
    }


 //  Listar todos
    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    //  Obtener por ID
    public Turno obtenerPorId(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }


//  Anular turno
    @Transactional
    public Turno anular(Long id) {
        Turno turno = obtenerPorId(id);

        if (turno.getEstado() == EstadoRegistro.FINALIZADO) {
            throw new RuntimeException("No se puede anular un turno finalizado");
        }

        turno.setEstado(EstadoRegistro.ANULADO);

        return turnoRepository.save(turno);
    }


  //  Finalizar turno
    @Transactional
    public Turno finalizar(Long id) {
        Turno turno = obtenerPorId(id);

        if (turno.getEstado() == EstadoRegistro.ANULADO) {
            throw new RuntimeException("No se puede finalizar un turno anulado");
        }

        turno.setEstado(EstadoRegistro.FINALIZADO);

        return turnoRepository.save(turno);
    }

    //  Eliminar (opcional)
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }

}
